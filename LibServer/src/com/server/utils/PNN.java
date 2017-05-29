package com.server.utils;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * 
 * @ClassName: PNN
 * @Description: �񾭸�������ʵ����
 * @author wxx
 * @date 2017��4��7�� 
 *
 */
public class PNN {
	public double[][] train; // ѵ����
	private String[] answer;// ��ѵ������Ӧ�Ľ��
	public double[][] test;// ���Լ�
	private double smooth;// ƽ������
	private double[] maxs; // ���ѵ������ÿ��ά�����ֵ��Ϊ�����һ������
	private double[] mins;// ���ѵ������ÿ��ά�ȵ���Сֵ��Ϊ�������
	private ArrayList<String> answerList = new ArrayList<String>();// ��Ű����Ľ������

	/*
	 * �÷���������ѵ�����ķ�������������������
	 * 
	 * @param double[][] train ����train ˫�����ά���� �Ǵ�����ѵ����
	 * 
	 * @param String[] answer ���� answer �ַ���һά���� ����ѵ�������Ӧ�Ľ��
	 * 
	 * @param String[] normal ����normal �ַ���һά���� ��Ҫ���еĹ�һ�������������ַ���˳����й�һ��
	 */
	public void setTrainSet(double[][] train, String[] answer, String[] normal)
			throws PNNException {
		// �������ѵ��������������������һ�£����׳����쳣
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
		// ���ζ�ѵ�������й�һ��
		for (int i = 0; i < normal.length; i++) {
			if (normal[i].equals("Euclidean")) {
				train = do_NormalbyEuclidean(train);
			} else if (normal[i].equals("Range")) {
				train = do_NormalbyRange(train);
			} else {
				// �����й�һ��
				// throw new PNNException(
				// "the PNN didn't contain normal method:"+normal[i]);
			}
		}
		// ��ֵ����Ա����train,answer
		this.train = train;
		this.answer = answer;
		// ���������͵���Ա����ansewerList
		for (int i = 0; i < answer.length; i++) {
			if (!answerList.contains(answer[i])) {
				answerList.add(answer[i]);
			}
		}

	}

	/**
	 * �÷��������ò��Լ��ķ�����������������
	 * 
	 * @param test  ����test ˫�����ά���� �Ǵ����Ĳ��Լ�
	 * 
	 * @param normal  ����smooth ��˫���������Ǵ�����ƽ������
	 * 
	 * @param smooth  ����normal �ַ���һά���� ��Ҫ���еĹ�һ�������������ַ���˳����й�һ��
	 */
	public void setTestSet(double[][] test, String[] normal, double smooth)
			throws PNNException {
		// �Ƿ�����ѵ����
		if (train == null) {
			throw new PNNException("you may didn't set trainSet");
		}
		// ���ѵ��������Լ���ά���Ƿ���ͬ�������׳��쳣
		if (test[0].length != train[0].length) {
			throw new PNNException(
					"testSet dimension is not equal trainSet dimension");
		}
		// ���ÿ������ά���Ƿ���ͬ
		for (int i = 0; i < test.length; i++) {
			if (test[i].length != test[0].length) {
				throw new PNNException("the " + (i + 1)
						+ " specimen is invalid");
			}
		}
		// ���ζԲ��Լ����й�һ��
		for (int i = 0; i < normal.length; i++) {
			if (normal[i].equals("Euclidean")) {
				test = do_NormalbyEuclidean(test);
			} else if (normal[i].equals("Range")) {
				test = do_NormalTestbyRange(test);
			} else {
				// �����й�һ��
				// throw new PNNException(
				// "the PNN didn't contain normal method:"+normal[i]);
			}
		}
		// ��ֵ����Ա����test��smooth
		this.test = test;
		this.smooth = smooth;
	}

	/**
	 * �÷��������ò��Լ��ķ�����������������
	 * 
	 * @param test ����test ˫�����ά���� �Ǵ����Ĳ��Լ�
	 * 
	 * @param normal ����smooth ��˫���������Ǵ�����ƽ������
	 * 
	 * @param smooth  ����normal �ַ���һά���� ��Ҫ���еĹ�һ�������������ַ���˳����й�һ��
	 */
	public void setTestSet(double[] test, String[] normal, double smooth)
			throws PNNException {
		double[][] test2 = new double[1][test.length];
		test2[0] = test;
		setTestSet(test2, normal, smooth);
	}

	/**
	 * �ú�����������
	 * 
	 * ���� �ַ���һά���飬�������Խ��������Ϊ���Լ�����
	 */
	public String[] Test() throws PNNException {
		//����������ÿ��ѵ�����ݵ�ŷ�Ͼ���
		double[][] temp = getDistance();
		
		//�õ�ÿ�����;����ܺ�
		double[][] distens=getSumProbabilty(temp);
		// Util.applendData(ConstantsValue.SOREPATH, 0, temp[0]);
		// Util.applendData(ConstantsValue.SOREPATH, 1, getSumProbabilty(temp)[0]);
		//����ת��Ϊ���ʣ��õĸ�˹����
		temp = getProbabilties(temp);
		// Util.applendData(ConstantsValue.SOREPATH, 2, temp[0]);
		//����ÿ�����͵ĸ����ܺ�
		temp = getSumProbabilty(temp);
		// Util.applendData(ConstantsValue.SOREPATH, 3, temp[0]);
		//System.out.println("-----------"+getMaxProbabilty(temp)[0]);
		//������������ͷ�������ʽ�ǣ����֣����������磺4:57.426
		String[] myteStrings = getTheResultAndScore(temp,distens);
		// Util.applendData(ConstantsValue.SOREPATH, 4, myteStrings);
		//System.out.println("-----"+myteStrings[0]);
		return myteStrings;
	}

	public int getSore() {

		return 0;

	}

	/**
	 * �����Զ���Ĺ�һ�����������õĹ�ʽ����ŷʽ����ķ��������õĹ�ʽ��
	 * 
	 * �ȼ���ÿ��������ÿ��ά�ȵ�ƽ����sum��Ȼ��ƽ��sum��
	 * 
	 * ֮����ʵ��ֵ����sum������һ������
	 * 
	 * @param origen  ����origen Ҫ���й�һ����˫�����ά����
	 * 
	 * ����һ����һ��֮��� ˫�����ά����
	 */
	public double[][] do_NormalbyEuclidean(double[][] origen) {
		// ����ÿ��ÿ������
		for (int i = 0; i < origen.length; i++) {

			double sum = 0d;
			// ��ÿ��������ÿ��ά��ƽ�����������
			for (int j = 0; j < origen[0].length; j++) {

				sum += origen[i][j] * origen[i][j];
			}
			// ��ƽ��
			sum = Math.sqrt(sum);
			// ���������һ��
			for (int j = 0; j < origen[0].length; j++) {

				origen[i][j] = origen[i][j] / sum;
			}
		}
		return origen;
	}

	/**
	 * ���Ǽ���Ĺ�һ�����������õĹ�ʽΪ
	 * 
	 * (value-minvalue)/(maxvalue-minvalue)
	 * 
	 * @param origen ����origen ��˫�����ά����
	 * 
	 * ����ֵ��һ����һ֮���˫��������
	 */

	public double[][] do_NormalbyRange(double[][] origen) {
		// ��ʼ������ÿ��ά�����ֵ����Сֵ��һά˫��������
		this.maxs = new double[origen[0].length];
		this.mins = new double[origen[0].length];
		// ����ά�Ƚ��б���
		for (int i = 0; i < origen[0].length; i++) {
			double min = Double.MAX_VALUE;
			double max = -Double.MAX_VALUE;
			// �ҳ�ÿ��ά�ȵ����ֵ
			for (int i1 = 0; i1 < origen.length; i1++) {
				if (origen[i1][i] > max) {
					max = origen[i1][i];
				}
				if (origen[i1][i] < min) {
					min = origen[i1][i];
				}
			}
			// �Ը�ά�Ƚ��й�һ��
			for (int j = 0; j < origen.length; j++) {
				origen[j][i] = (origen[j][i] - min) / (max - min);
			}
			// �����ά�ȵ�һά������
			maxs[i] = max;
			mins[i] = min;
		}

		return origen;
	}

	/**
	 * �÷���Ϊ�Բ��Լ����м����һ��
	 * 
	 * ��ѵ�����б����ÿ��ά�ȵ����ֵ����Сֵ��ֱ�ӽ��й�һ��
	 * 
	 * ����ֵΪ��һ��֮���˫�����ά����
	 */
	public double[][] do_NormalTestbyRange(double[][] origen)
			throws PNNException {
		// �ж��Ƿ�ѵ���������˼����һ���������׳��쳣
		if (mins.length < 1 || mins == null) {
			throw new PNNException("you may didn't use Range normal trainSet");
		}
		// ���ζ����ݽ��й�һ��
		for (int i = 0; i < origen.length; i++) {
			for (int j = 0; j < origen[0].length; j++) {

				origen[i][j] = (origen[i][j] - mins[j]) / (maxs[j] - mins[j]);
			}
		}

		return origen;
	}

	/**
	 * 
	 * �÷��������������ѵ����֮���ŷʽ����
	 * 
	 * ����ֵΪһ����ά˫�������顣ÿ����Ϊ���Լ���������Ϊѵ����������
	 * 
	 * ���Ӧ�ĵĸò���������ѵ�������ľ���
	 */
	public double[][] getDistance() throws PNNException {
		// ����Ƿ�������ѵ�����Ͳ��Լ�
		if (test == null || test.length < 1) {
			throw new PNNException("you may didn't set the testSet");
		}
		if (train == null || train.length < 1) {
			throw new PNNException("you may didn't set the trainSet");
		}
		// �½�һ��˫�����ά���飬����Ϊ������������Ŀ������Ϊѵ����������Ŀ
		double[][] result = new double[test.length][train.length];
		// ����ŷʽ���룬�������ڶ�ά������
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
	 * �ú���ʹ�ø�˹������������ת��Ϊ����
	 * 
	 * ����˫�����ά����
	 */

	public double[][] getProbabilties(double[][] result) {
		// ��������������и�˹��������
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {

				result[i][j] = 1 / Math.pow(Math.E, result[i][j]
						/ (2 * smooth * smooth));
			}
		}

		return result;
	}

	/**
	 * �ú�������ͬһ��ĸ��ʽ������
	 * 
	 * ����һ��˫�����ά���飬����Ϊ�������ݼ�����������Ϊ���������
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
	 * ���ÿһ���и��ʵ����ֵ����ת��Ϊ���
	 * 
	 * ����ֵΪ�ַ���һά����
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
	 * ����Ĳ���Ϊ���Ե�ÿ�ֵĸ��ʣ����ط������͵÷֣�����ķ�ʽ
	 * 
	 * ��������ע�⣬�쳣�����صľ�����a,b,c,dʱ
	 * ��÷ֵļ������£�
	 * �����÷֣�100 - 15 * a/(a+b)
	 * ע��÷֣�80 + 5 * (c -a)/(a+b+c)
	 * �쳣�÷֣�67.5 + 7.5 * (d - b)/(b+c+d)
	 * ���ص÷֣�60 - 15 *(c-d)/(c+d)
	 * 
	 * @param result
	 * @return
	 */
	public String[] getTheResultAndScore(double[][] result,double[][] distance) throws PNNException {
		DecimalFormat df = new DecimalFormat("######0.000");

		if (result[0].length != 4)
			throw new PNNException("��ʽ������Ҫ�������ʽ");
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
			// ת��Ϊ��Ϊ1�ĸ���

		
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
