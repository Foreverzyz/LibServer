package com.server.utils;

import java.util.Date;
import java.util.Random;

class netword {

	public static float biasvalue = -1;// 偏移值
	public static float learnRate = 0.25f;// 学习率
	public netword child;                // 当前节点的子节点
	public netword perent; 				// 当前节点的父节点

	public float[][] linkweight; // 连接权重
	public float[] biasweight;   // 偏移权重
	public float[] value;        // 节点值
	public float[] desiedvalue;  // 真实值
	public float[] error;// 误差
	public float[][] lastturn_detweigth;// 上次训练得到的连接权重更新值（主要用于调整权重）

	public int numself;// 当前节点数目
	public int childnum;// 子节点数目
	Random r = new Random((new Date()).getTime());//

	public netword(int num, int cnum) {
		numself = num;
		childnum = cnum;
		initlize();
	}

	public void initlize()// 初始化神经网络
	{
		linkweight = new float[numself][childnum];
		lastturn_detweigth = new float[numself][childnum];
		/******
		 * 这里两重循环主要是给（输入层-隐匿层）和（隐匿层-输出层）的连接权重赋值
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
			biasweight[i] = r.nextFloat();// 对偏移权重赋初值
			error[i] = 0;
		}
	}

	// 向后计算各层的值；其中输入层的值为输入的数据，无需计算，隐匿层和输出层的值利用公式(神经元[i]的值=所有父亲节点的值与当前节点的连接权重乘积之和+偏移值*偏移权重)
	/**************
	 * 
	 * 或者公式 currentnode[i]=Math.exp((currentnode[i].perent.value[0]+......+
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

	public void clculateError()// 计算各层的误差值，其中输入层不存在误差，
	{
		if (perent != null) {
			if (child == null)// out输出层误差
								// 计算公式:out[i].error=(out[i].desirevalue-out[i].value)*out[i].value*(1-out[i].value)
			{
				for (int i = 0; i < numself; i++) {
					error[i] = (desiedvalue[i] - value[i]) * value[i]
							* (1 - value[i]);
					// System.out.println("**"+error[i]);
				}
			} else// hidden 隐匿层误差计算公式
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

	public void UpdateWeight()// 调整权重
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