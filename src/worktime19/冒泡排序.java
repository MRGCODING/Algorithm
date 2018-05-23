package worktime19;

import java.util.Arrays;

public class 冒泡排序 {
	public static int getSecond(int[] arr) {
		for (int j = 0; j < 2; j++) {
			for (int i = 0; i < arr.length - 1; i++) {
				if (arr[i + 1] < arr[i]) {
					int temp = arr[i + 1];
					arr[i + 1] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr[arr.length - 2];
	}

	public static int getSecondFinal(int[] arr) {
		int t1 = 0, t2 = 0;
		//第一次排序找最大
		for (int i = 0; i < arr.length; i++) {
			if (t1 < arr[i]) {
				t1 = arr[i];
			}
		}
		//第二次排序找第二大
		for (int i = 0; i < arr.length; i++) {
			if (t2 < arr[i] && arr[i] != t1) {
				t2 = arr[i];
			}
		}
		return t2;
	}

	public static int getSecondtheOne(int[] arr) {
		int t1 = arr[0], t2 = 0;
		for (int i = 0; i < arr.length; i++) {
			if (t1 < arr[i]) {
				t2 = t1;
				t1 = arr[i];
			} else {
				t2 = t2 < arr[i] ? arr[i] : t2;
			}
		}
		return t2;
	}

	public static void main(String[] args) {
		int[] arr = { 7, 6, 4, 3, 2, 1 };
		int second = getSecondFinal(arr);
		System.out.println(second);
	}
}
