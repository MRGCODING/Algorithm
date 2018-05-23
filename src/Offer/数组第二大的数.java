package Offer;

public class 数组第二大的数 {
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
}
