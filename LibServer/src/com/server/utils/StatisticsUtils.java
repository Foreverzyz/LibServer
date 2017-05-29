package com.server.utils;

import java.text.DecimalFormat;

public class StatisticsUtils {
	
	public static void main(String[] args) {
		
		// 设置doubl字符串输出格式，不以科学计数法输出
		DecimalFormat df = new DecimalFormat("#,##0.00");// 格式化设置
		// 计算方差
		//double dV = Variance(x);
		//System.out.println("方差=" + df.format(dV));
		// 计算标准差
		//double dS = StandardDiviation(x);
		//System.out.println("标准差=" + df.format(dS));
	}

	// 方差s^2=[(x1-x)^2 +...(xn-x)^2]/n
	public static double VarianceCaculate(double[] x) {
		int m = x.length;
		double dAve = AverageCaculate(x);// 求平均值
		double dVar = 0;
		for (int i = 0; i < m; i++) {// 求方差
			dVar += (x[i] - dAve) * (x[i] - dAve);
		}
		return dVar / m;
	}

	// 求均值
	public static double AverageCaculate(double[] x) {
		int m = x.length;
		double sum = 0;
		for (int i = 0; i < m; i++) {// 求和
			sum += x[i];
		}
		double dAve = sum / m;// 求平均值
		return dAve;
	}

	
	// 标准差σ=sqrt(s^2)
	public static double StandardDiviation(double[] x) {	
		return Math.sqrt(VarianceCaculate(x));
	}
	
	//计算正态分布函数
	public static double[] GaosiCaculate(double[] x) {	
		
		double[] data = new double[x.length];
		double sdata = StandardDiviation(x);
		double avg = AverageCaculate(x);
		
		System.err.println("平均数="+avg);
		for(int i = 0; i < x.length; i++){
			data[i] = (1/(sdata * Math.sqrt(2 * Math.PI)) * Math.exp(-Math.pow((x[i]-avg), 2)/(2 * Math.pow(sdata, 2))));
		}
		for(double xda : data){
			System.out.println(xda);
		}
		return data;
	}
}
