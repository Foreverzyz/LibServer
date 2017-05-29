package com.server.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * 
 * @ClassName: PNN
 * @Description: 神经概率网络实现类
 * @author wxx
 * @date 2017年4月7日 
 *
 */
public class PNN {
	public double[][] train; // 训练集
	private String[] answer;// 与训练集对应的结果
	public double[][] test;// 测试集
	private double smooth;// 平滑因子
	private double[] maxs; // 存放训练集中每个维度最大值，为极差法归一化工作
	private double[] mins;// 存放训练集中每个维度的最小值，为极差法工作
	private ArrayList<String> answerList = new ArrayList<String>();// 存放包含的结果类型

	/*
	 * 该方法是设置训练集的方法，包括三个参数：
	 * 
	 * @param double[][] train 参数train 双浮点二维数组 是传进的训练集
	 * 
	 * @param String[] answer 参数 answer 字符串一维数组 是与训练集相对应的结果
	 * 
	 * @param String[] normal 参数normal 字符串一维数组 是要进行的归一化方法，按照字符串顺序进行归一化
	 */
	public void setTrainSet(double[][] train, String[] answer, String[] normal)
			throws PNNException {
		// 如果发现训练集的数量与结果数量不一致，将抛出该异常
		if (train.length != answer.length) {
			throw new PNNException(
					"trainset length is not equal answer's length");

		}
		for (int i = 0; i < train.length; i++) {
			if (train[i].length != train[0].length) {
				throw new PNNException("the " + (i + 1)
						+ " specimen is invalid");
			}
		}
		// 依次对训练集进行归一化
		for (int i = 0; i < normal.length; i++) {
			if (normal[i].equals("Euclidean")) {
				train = do_NormalbyEuclidean(train);
			} else if (normal[i].equals("Range")) {
				train = do_NormalbyRange(train);
			} else {
				// 不进行归一化
				// throw new PNNException(
				// "the PNN didn't contain normal method:"+normal[i]);
			}
		}
		// 赋值给成员变量train,answer
		this.train = train;
		this.answer = answer;
		// 保存结果类型到成员变量ansewerList
		for (int i = 0; i < answer.length; i++) {
			if (!answerList.contains(answer[i])) {
				answerList.add(answer[i]);
			}
		}

	}

	/**
	 * 该方法是设置测试集的方法，包含三个参数
	 * 
	 * @param test  参数test 双浮点二维数组 是传进的测试集
	 * 
	 * @param normal  参数smooth 是双浮点数，是传进的平滑因子
	 * 
	 * @param smooth  参数normal 字符串一维数组 是要进行的归一化方法，按照字符串顺序进行归一化
	 */
	public void setTestSet(double[][] test, String[] normal, double smooth)
			throws PNNException {
		// 是否设置训练集
		if (train == null) {
			throw new PNNException("you may didn't set trainSet");
		}
		// 检查训练集与测试集的维度是否相同，否则抛出异常
		if (test[0].length != train[0].length) {
			throw new PNNException(
					"testSet dimension is not equal trainSet dimension");
		}
		// 检查每个样本维度是否相同
		for (int i = 0; i < test.length; i++) {
			if (test[i].length != test[0].length) {
				throw new PNNException("the " + (i + 1)
						+ " specimen is invalid");
			}
		}
		// 依次对测试集进行归一化
		for (int i = 0; i < normal.length; i++) {
			if (normal[i].equals("Euclidean")) {
				test = do_NormalbyEuclidean(test);
			} else if (normal[i].equals("Range")) {
				test = do_NormalTestbyRange(test);
			} else {
				// 不进行归一化
				// throw new PNNException(
				// "the PNN didn't contain normal method:"+normal[i]);
			}
		}
		// 赋值给成员变量test，smooth
		this.test = test;
		this.smooth = smooth;
	}

	/**
	 * 该方法是设置测试集的方法，包含三个参数
	 * 
	 * @param test 参数test 双浮点二维数组 是传进的测试集
	 * 
	 * @param normal 参数smooth 是双浮点数，是传进的平滑因子
	 * 
	 * @param smooth  参数normal 字符串一维数组 是要进行的归一化方法，按照字符串顺序进行归一化
	 */
	public void setTestSet(double[] test, String[] normal, double smooth)
			throws PNNException {
		double[][] test2 = new double[1][test.length];
		test2[0] = test;
		setTestSet(test2, normal, smooth);
	}

	/**
	 * 该函数启动测试
	 * 
	 * 返回 字符串一维数组，包含测试结果，长度为测试集数量
	 */
	public String[] Test() throws PNNException {
		//测试数据与每个训练数据的欧氏距离
		double[][] temp = getDistance();
		
		//得到每种类型距离总和
		double[][] distens=getSumProbabilty(temp);
		// Util.applendData(ConstantsValue.SOREPATH, 0, temp[0]);
		// Util.applendData(ConstantsValue.SOREPATH, 1, getSumProbabilty(temp)[0]);
		//距离转化为概率，用的高斯函数
		temp = getProbabilties(temp);
		// Util.applendData(ConstantsValue.SOREPATH, 2, temp[0]);
		//计算每种类型的概率总和
		temp = getSumProbabilty(temp);
		// Util.applendData(ConstantsValue.SOREPATH, 3, temp[0]);
		//System.out.println("-----------"+getMaxProbabilty(temp)[0]);
		//计算出分类结果和分数，格式是：数字：分数，例如：4:57.426
		String[] myteStrings = getTheResultAndScore(temp,distens);
		// Util.applendData(ConstantsValue.SOREPATH, 4, myteStrings);
		//System.out.println("-----"+myteStrings[0]);
		return myteStrings;
	}

	public int getSore() {

		return 0;

	}

	/**
	 * 这是自定义的归一化函数，采用的公式类似欧式距离的方法，采用的公式是
	 * 
	 * 先计算每个样本的每个维度的平方和sum，然后开平方sum。
	 * 
	 * 之后用实际值除以sum，包含一个参数
	 * 
	 * @param origen  参数origen 要进行归一化的双浮点二维数组
	 * 
	 * 返回一个归一化之后的 双浮点二维数组
	 */
	public double[][] do_NormalbyEuclidean(double[][] origen) {
		// 遍历每个每个样本
		for (int i = 0; i < origen.length; i++) {

			double sum = 0d;
			// 对每个样本的每个维度平方，并计算和
			for (int j = 0; j < origen[0].length; j++) {

				sum += origen[i][j] * origen[i][j];
			}
			// 开平方
			sum = Math.sqrt(sum);
			// 进行相除归一化
			for (int j = 0; j < origen[0].length; j++) {

				origen[i][j] = origen[i][j] / sum;
			}
		}
		return origen;
	}

	/**
	 * 这是极差法的归一化方法，采用的公式为
	 * 
	 * (value-minvalue)/(maxvalue-minvalue)
	 * 
	 * @param origen 参数origen 是双浮点二维数组
	 * 
	 * 返回值是一个归一之后的双浮点数组
	 */

	public double[][] do_NormalbyRange(double[][] origen) {
		// 初始化保存每个维度最大值和最小值的一维双浮点数组
		this.maxs = new double[origen[0].length];
		this.mins = new double[origen[0].length];
		// 按照维度进行遍历
		for (int i = 0; i < origen[0].length; i++) {
			double min = Double.MAX_VALUE;
			double max = -Double.MAX_VALUE;
			// 找出每个维度的最大值
			for (int i1 = 0; i1 < origen.length; i1++) {
				if (origen[i1][i] > max) {
					max = origen[i1][i];
				}
				if (origen[i1][i] < min) {
					min = origen[i1][i];
				}
			}
			// 对该维度进行归一化
			for (int j = 0; j < origen.length; j++) {
				origen[j][i] = (origen[j][i] - min) / (max - min);
			}
			// 保存该维度到一维数组中
			maxs[i] = max;
			mins[i] = min;
		}

		return origen;
	}

	/**
	 * 该方法为对测试集进行极差法归一化
	 * 
	 * 由训练集中保存的每个维度的最大值和最小值，直接进行归一化
	 * 
	 * 返回值为归一化之后的双浮点二维数组
	 */
	public double[][] do_NormalTestbyRange(double[][] origen)
			throws PNNException {
		// 判断是否训练集进行了极差归一化，否则抛出异常
		if (mins.length < 1 || mins == null) {
			throw new PNNException("you may didn't use Range normal trainSet");
		}
		// 依次对数据进行归一化
		for (int i = 0; i < origen.length; i++) {
			for (int j = 0; j < origen[0].length; j++) {

				origen[i][j] = (origen[i][j] - mins[j]) / (maxs[j] - mins[j]);
			}
		}

		return origen;
	}

	/**
	 * 
	 * 该方法求出，样本与训练集之间的欧式距离
	 * 
	 * 返回值为一个二维双浮点数组。每行数为测试集数量，列为训练集数量，
	 * 
	 * 相对应的的该测试样本和训练样本的距离
	 */
	public double[][] getDistance() throws PNNException {
		// 检查是否设置了训练集和测试集
		if (test == null || test.length < 1) {
			throw new PNNException("you may didn't set the testSet");
		}
		if (train == null || train.length < 1) {
			throw new PNNException("you may didn't set the trainSet");
		}
		// 新建一个双浮点二维数组，行数为测试样本集数目，列数为训练样本集数目
		double[][] result = new double[test.length][train.length];
		// 计算欧式距离，并保存在二维数组中
		for (int i = 0; i < test.length; i++) {
			for (int j = 0; j < train.length; j++) {
				double temp = 0;
				for (int j2 = 0; j2 < train[0].length; j2++) {
					temp += (test[i][j2] - train[j][j2])
							* (test[i][j2] - train[j][j2]);
				}

				temp = Math.sqrt(temp);
				result[i][j] = temp;

			}
		}

		return result;
	}

	/**
	 * 该函数使用高斯函数，将距离转化为概率
	 * 
	 * 返回双浮点二维数组
	 */

	public double[][] getProbabilties(double[][] result) {
		// 对数组遍历，进行高斯函数计算
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {

				result[i][j] = 1 / Math.pow(Math.E, result[i][j]
						/ (2 * smooth * smooth));
			}
		}

		return result;
	}

	/**
	 * 该函数对相同一类的概率进行相加
	 * 
	 * 返回一个双浮点二维数组，行数为测试数据集数量，列数为分类的数量
	 */
	public double[][] getSumProbabilty(double[][] result) {
		double[][] res = new double[test.length][answerList.size()];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				res[i][answerList.indexOf(answer[j])] += result[i][j];
				String s = answer[j];
				if (s.equals("1")) {
					res[i][0] += result[i][j];
				}
				if (s.equals("2")) {
					res[i][1] += result[i][j];
				}
				if (s.equals("3")) {
					res[i][2] += result[i][j];
				}
				if (s.equals("4")) {
					res[i][3] += result[i][j];
				}

			}

		}

		return res;

	}

	/**
	 * 算出每一行中概率的最大值，并转化为结果
	 * 
	 * 返回值为字符串一维数组
	 */
	public String[] getMaxProbabilty(double[][] result) {
		String[] re = new String[result.length];
		for (int i = 0; i < result.length; i++) {
			double max = -1;
			int k = -1;
			for (int j = 0; j < result[0].length; j++) {
				if (max < result[i][j]) {
					max = result[i][j];
					k = j;
				}
			}
			if (k == -1) {
				System.out.println(result);
			}
			re[i] = answerList.get(k);
		}
		return re;
	}

	/**
	 * 传入的参数为测试的每种的概率，返回分类结果和得分，计算的方式
	 * 
	 * 设正常，注意，异常，严重的距离是a,b,c,d时
	 * 则得分的计算如下：
	 * 正常得分：100 - 15 * a/(a+b)
	 * 注意得分：80 + 5 * (c -a)/(a+b+c)
	 * 异常得分：67.5 + 7.5 * (d - b)/(b+c+d)
	 * 严重得分：60 - 15 *(c-d)/(c+d)
	 * 
	 * @param result
	 * @return
	 */
	public String[] getTheResultAndScore(double[][] result,double[][] distance) throws PNNException {
		DecimalFormat df = new DecimalFormat("######0.000");

		if (result[0].length != 4)
			throw new PNNException("格式不符合要求，请检查格式");
		String[] re = new String[result.length];
		for (int i = 0; i < re.length; i++) {
			double sum = 0;
			String[] keysString = new String[4];
			Double[] valueDoubles = new Double[4];
			for (int j = 0; j < valueDoubles.length; j++) {
				String s = answerList.get(j).trim();
				if (s.equals("1")) {
					keysString[0] = "1";
					valueDoubles[0] = result[i][j];
				}
				if (s.equals("2")) {
					keysString[1] = "2";
					valueDoubles[1] = result[i][j];
				}
				if (s.equals("3")) {
					keysString[2] = "3";
					valueDoubles[2] = result[i][j];
				}
				if (s.equals("4")) {
					keysString[3] = "4";
					valueDoubles[3] = result[i][j];
				}
			}
			// 转化为和为1的概率

		
			double max = -1;
			int k = -1;
			for (int j = 0; j < result[0].length; j++) {
				if (max < result[i][j]) {
					max = result[i][j];
					k = j;
				}
			}
			if (k == -1) {
				System.out.println(result);
			}
			re[i] = answerList.get(k);
			double a=distance[0][0];
			double b=distance[0][1];
			double c=distance[0][2];
			double d=distance[0][3];
			
			//System.out.printf("%s:%s:%s:%s", a,b,c,d);
			
			switch (re[i]) {
			case "1":
				
				re[i] = re[i] + ":" + df.format(100 - 15 * a/(a+b));
				break;
			case "2":
				re[i] = re[i]
						+ ":"
						+ df.format(80 + 5 * (c -a)/(a+b+c));
				break;
			case "3":
				re[i] = re[i]
						+ ":"
						+ df.format(67.5 + 7.5 * (d - b)/(b+c+d));
				break;
			case "4":
				re[i] = re[i] + ":" + df.format(60 - 15 *(c-d)/(c+d));
				break;

			default:
				throw new PNNException("get Sore Wrong");
			}
		}

		return re;
	}
}
