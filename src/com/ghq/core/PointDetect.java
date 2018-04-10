package com.ghq.core;

import java.util.Arrays;

public class PointDetect {
	public static void main(String[] args) {
		double[] list = {0,0,0,0,0,0,0,0,0,0,0,0,1,2,15};
		Arrays.sort(list);
		for(int i = 0;i < list.length;i++){
			double iq = list[list.length / 4 - 1];
			double uq = list[list.length / 4 * 3 - 1];
			double iqr = uq - iq;
			double count1 = uq + 19 * iqr,count2 = iq - 19 * iqr; 
			if(list[i] < count2 || list[i] > count1)
				list[i] = -1;
		}
		for (double d : list) {
			System.out.print(d + ",");
		}
	}
}
