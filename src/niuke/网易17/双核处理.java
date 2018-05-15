package niuke.网易17;

import java.util.Scanner;

public class 双核处理 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] length = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			length[i] = sc.nextInt() / 1024;
			sum += length[i];
		}
		int[] dp = new int[sum / 2 + 1];
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = sum / 2; j >= length[i]; j--) {
				dp[j] = Math.max(dp[j], dp[j - length[i]] + length[i]);
			}
		}
		System.out.println(Math.max(dp[sum / 2], sum - dp[sum / 2]) << 10);
//		System.out.println((sum / 2 + 1) * 1024);
		/*
		 * int[][] handler = new int[n + 1][sum / 2 + 1]; for (int i = 0; i <=
		 * n; i++) for (int j = 0; j <= sum / 2; j++) { handler[i][j] = i == 0 ?
		 * 0 : handler[i - 1][j]; // 循环到i时 if (i > 0 && j >= length[i - 1])
		 * handler[i][j] = Math.max(handler[i - 1][j], handler[i - 1][j -
		 * length[i - 1]] + length[i - 1]); }
		 * System.out.print(Math.max(handler[n][sum / 2], sum - handler[n][sum /
		 * 2]) * 1024);
		 */
	}
}