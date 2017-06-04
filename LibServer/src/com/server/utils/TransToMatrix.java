package com.server.utils;

public class TransToMatrix {
	
	public static float[] getCloumn(Modeldata modeldata, int size){
		float [] array = new float[size];
		array[0] = modeldata.getBssid1();
		array[1] = modeldata.getBssid2();
		array[2] = modeldata.getBssid3();
		array[3] = modeldata.getBssid4();
		array[4] = modeldata.getBssid5();
		array[5] = modeldata.getBssid6();
		array[6] = modeldata.getBssid7();
		array[7] = modeldata.getBssid8();
		array[8] = modeldata.getBssid9();
		array[9] = modeldata.getBssid10();
		array[10] = modeldata.getBssid11();
		array[11] = modeldata.getBssid12();
		array[12] = modeldata.getBssid13();
		array[13] = modeldata.getBssid14();
		array[14] = modeldata.getBssid15();
		array[15] = modeldata.getBssid16();
		array[16] = modeldata.getBssid17();
		array[17] = modeldata.getBssid18();
		array[18] = modeldata.getBssid19();
		array[19] = modeldata.getBssid20();
		array[20] = modeldata.getBssid21();
		array[21] = modeldata.getBssid22();
		array[22] = modeldata.getBssid23();
		array[23] =	modeldata.getBssid24();
		array[24] =	modeldata.getBssid25();
		array[25] =	modeldata.getBssid26();
		return array;
	}
}
