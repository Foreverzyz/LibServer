package com.server.utils;

import java.text.DecimalFormat;

public class StatisticsUtils {
	
	public static void main(String[] args) {
		
		// ����doubl�ַ��������ʽ�����Կ�ѧ���������
		DecimalFormat df = new DecimalFormat("#,##0.00");// ��ʽ������
		// ���㷽��
		//double dV = Variance(x);
		//System.out.println("����=" + df.format(dV));
		// �����׼��
		//double dS = StandardDiviation(x);
		//System.out.println("��׼��=" + df.format(dS));
	}

	// ����s^2=[(x1-x)^2 +...(xn-x)^2]/n
	public static double VarianceCaculate(double[] x) {
		int m = x.length;
		double dAve = AverageCaculate(x);// ��ƽ��ֵ
		double dVar = 0;
		for (int i = 0; i < m; i++) {// �󷽲�
			dVar += (x[i] - dAve) * (x[i] - dAve);
		}
		return dVar / m;
	}

	// ���ֵ
	public static double AverageCaculate(double[] x) {
		int m = x.length;
		double sum = 0;
		for (int i = 0; i < m; i++) {// ���
			sum += x[i];
		}
		double dAve = sum / m;// ��ƽ��ֵ
		return dAve;
	}

	
	// ��׼���=sqrt(s^2)
	public static double StandardDiviation(double[] x) {	
		return Math.sqrt(VarianceCaculate(x));
	}
	
	//������̬�ֲ�����
	public static double[] GaosiCaculate(double[] x) {	
		
		double[] data = new double[x.length];
		double sdata = StandardDiviation(x);
		double avg = AverageCaculate(x);
		
		System.err.println("ƽ����="+avg);
		for(int i = 0; i < x.length; i++){
			data[i] = (1/(sdata * Math.sqrt(2 * Math.PI)) * Math.exp(-Math.pow((x[i]-avg), 2)/(2 * Math.pow(sdata, 2))));
		}
		for(double xda : data){
			System.out.println(xda);
		}
		return data;
	}
}
