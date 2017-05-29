package com.server.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.io.OutputStreamWriter;

import Catalano.Math.Matrix;

public class TxtUtils {
	public static String filepath = "E:\\all.txt";

	public static void main(String[] args) throws IOException {
		// String path = "E:\\RSSIdata\\dataBssid.txt";
		File savefile = new File(filepath);
		if (!savefile.exists()) {
			savefile.createNewFile();
		}
		BufferedWriter bufferWritter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(savefile, true)));

		for (int k = 23; k < 141; k++) {
			bufferWritter.write(k + "\n");
			String path1 = "E:\\RSSIdata\\dataRssi_at_" + k + ".txt";
			System.err.println(path1);
			int datasize[] = getSize(path1);
			double data[][] = new double[datasize[0]][datasize[1]];
			data = readTxtFile(path1, datasize);
			for (double[] rows : data) {
				for (int i = 0; i < rows.length - 15; i++) {
					bufferWritter.write(rows[i] + "\t");
				}
				bufferWritter.write("\n");
			}
			bufferWritter.flush();
		}
		bufferWritter.close();

		/*
		 * System.out.println("提取某一列"); double[] x = Matrix.getColumn(data, 0);
		 * for(double xd : x){ System.out.print(xd + "\n"); }
		 * System.out.println();
		 */
	}

	// 计算矩阵行列数
	public static int[] getSize(String filepath) throws IOException {
		int[] size = new int[2];
		String encoding = "utf-8";
		File file = new File(filepath);
		if (file.isFile() && file.exists()) {
			InputStreamReader read = new InputStreamReader(new FileInputStream(
					file), encoding);
			BufferedReader bReader = new BufferedReader(read);
			String line = null;
			int num = 0; // 记录行数
			String[] sp;
			// 开始读取文本数据
			while ((line = bReader.readLine()) != null) {
				sp = line.split("\\t");
				size[1] = sp.length;
				num++;
			}
			// System.out.println("列数："+size[1]);
			size[0] = num;
			// System.out.println("行数："+size[0]);
		}

		return size;
	}

	// 文本数据获取转成数值型数据
	public static double[][] readTxtFile(String filepath, int[] size)
			throws IOException {
		String encoding = "utf-8";
		File file = new File(filepath);
		double[][] array = new double[size[0]][size[1]];
		if (file.isFile() && file.exists()) {
			try {
				InputStreamReader read = new InputStreamReader(
						new FileInputStream(file), encoding);
				BufferedReader bReader = new BufferedReader(read);

				String line = null;
				int num = 0; // 记录行数
				String[] sp;
				double[] lineArray; // 存放每一行转成整型后的数据
				// 开始读取文本数据
				while ((line = bReader.readLine()) != null) {
					sp = line.split("\\\t"); // 按制表符分割提取每一行的字符串
					lineArray = new double[sp.length]; // sp.length
														// 为每行的数据长度,也就是列数
					// System.out.println("列数：" + sp.length);
					for (int j = 0, l = sp.length; j < l; ++j) {
						lineArray[j] = Double.valueOf(sp[j]);
					}
					array[num] = lineArray; // 每行存入矩阵中
					num++;
				}
				// System.out.println("行数：" + num);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
		return array;
	}
}
