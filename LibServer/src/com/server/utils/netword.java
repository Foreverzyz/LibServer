package com.server.utils;

import java.util.Date;
import java.util.Random;

class netword {

	public static float biasvalue = -1;// ƫ��ֵ
	public static float learnRate = 0.25f;// ѧϰ��
	public netword child;                // ��ǰ�ڵ���ӽڵ�
	public netword perent; 				// ��ǰ�ڵ�ĸ��ڵ�

	public float[][] linkweight; // ����Ȩ��
	public float[] biasweight;   // ƫ��Ȩ��
	public float[] value;        // �ڵ�ֵ
	public float[] desiedvalue;  // ��ʵֵ
	public float[] error;// ���
	public float[][] lastturn_detweigth;// �ϴ�ѵ���õ�������Ȩ�ظ���ֵ����Ҫ���ڵ���Ȩ�أ�

	public int numself;// ��ǰ�ڵ���Ŀ
	public int childnum;// �ӽڵ���Ŀ
	Random r = new Random((new Date()).getTime());//

	public netword(int num, int cnum) {
		numself = num;
		childnum = cnum;
		initlize();
	}

	public void initlize()// ��ʼ��������
	{
		linkweight = new float[numself][childnum];
		lastturn_detweigth = new float[numself][childnum];
		/******
		 * ��������ѭ����Ҫ�Ǹ��������-����㣩�ͣ������-����㣩������Ȩ�ظ�ֵ
		 * 
		 * */
		for (int i = 0; i < numself; i++) {
			for (int j = 0; j < childnum; j++) {
				linkweight[i][j] = r.nextFloat();
				lastturn_detweigth[i][j] = 0;
			}
		}
		value = new float[numself];
		desiedvalue = new float[numself];
		biasweight = new float[numself];
		error = new float[numself];
		for (int i = 0; i < numself; i++) {
			value[i] = 0;
			desiedvalue[i] = 0;
			biasweight[i] = r.nextFloat();// ��ƫ��Ȩ�ظ���ֵ
			error[i] = 0;
		}
	}

	// ����������ֵ������������ֵΪ��������ݣ�������㣬������������ֵ���ù�ʽ(��Ԫ[i]��ֵ=���и��׽ڵ��ֵ�뵱ǰ�ڵ������Ȩ�س˻�֮��+ƫ��ֵ*ƫ��Ȩ��)
	/**************
	 * 
	 * ���߹�ʽ currentnode[i]=Math.exp((currentnode[i].perent.value[0]+......+
	 * currentnode
	 * [i].perent.value[n])+currentnode[i].biasvlue*currentnode[i].biasweight);
	 * 
	 * 
	 * ******/
	public void clculateValue() {
		if (perent != null) {
			for (int i = 0; i < numself; i++) {
				float ttp = 0;
				for (int j = 0; j < perent.numself; j++) {
					ttp += (perent.linkweight[j][i] * perent.value[j]);
				}
				ttp += (ttp * biasvalue * biasweight[i]);
				value[i] = (float) (1 / (1 + Math.exp(-ttp)));// ttp;/*******************/
			}
		}
	}

	public void clculateError()// �����������ֵ����������㲻������
	{
		if (perent != null) {
			if (child == null)// out��������
								// ���㹫ʽ:out[i].error=(out[i].desirevalue-out[i].value)*out[i].value*(1-out[i].value)
			{
				for (int i = 0; i < numself; i++) {
					error[i] = (desiedvalue[i] - value[i]) * value[i]
							* (1 - value[i]);
					// System.out.println("**"+error[i]);
				}
			} else// hidden ����������㹫ʽ
					// hidden[i].error=(out[0].error*linkweight[i][0]*hidden[i].value*(1-hidden[i].value)+....+out[0].error*linkweight[i][n]*hidden[i].value*(1-hidden[i].value))
			{
				for (int i = 0; i < numself; i++) {
					float ttp = 0;
					for (int j = 0; j < childnum; j++) {
						//
						ttp += (linkweight[i][j] * child.error[j]) * value[i]
								* (1 - value[i]);
					}
					error[i] = ttp;
				}
			}
		} else// int
		{
			for (int i = 0; i < numself; i++) {
				error[i] = 0;
			}
		}
	}

	public void UpdateWeight()// ����Ȩ��
	{
		if (child != null) {
			for (int i = 0; i < numself; i++) {
				for (int j = 0; j < childnum; j++) {
					float detweight = (learnRate * child.error[j] * value[i]);
					linkweight[i][j] += (detweight + lastturn_detweigth[i][j] * 0.9f/*************/
					);

					lastturn_detweigth[i][j] = detweight;
				}
				// biasweight[i]=(learnRate*error[i]*biasvalue);
			}
		}
	}

	public void setPerent(netword p) {
		perent = p;
	}

	public void setChild(netword c) {
		child = c;
	}
}