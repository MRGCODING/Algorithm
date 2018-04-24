package niuke2016;

import java.util.Scanner;

public class 最长递增子序列 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int num = 0;
		while (n != 0) {
			num = sc.nextInt();
			int[] arr = new int[num];
			for (int i = 0; i < num; i++) {
				arr[i] = sc.nextInt();
			}
			int[] dp = new int[num];
			for (int i = 0; i < num; i++)
				dp[i] = 1;
			int res = 0;
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < i; j++) {
					if (arr[i] > arr[j]) {
						dp[i] = Math.max(dp[i], dp[j] + 1);
					}
				}
				res = Math.max(res, dp[i]);
			}
			System.out.println(res);
			n--;
		}
	}
}