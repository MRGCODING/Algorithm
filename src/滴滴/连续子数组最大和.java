package 滴滴;

import java.util.Scanner;

public class 连续子数组最大和 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int[] arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = sc.nextInt();
			}

			int res = Integer.MIN_VALUE;
			int sum = arr[0];
			for (int i = 0; i < n; i++) {
				if (sum <= 0) {
					sum = arr[i];
				} else {
					sum += arr[i];
				}
				if (sum > res)
					res = sum;
			}
			System.out.println(res);
		}
	}
}
