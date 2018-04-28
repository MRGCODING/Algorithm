package niuke2017;

import java.util.Scanner;

public class 拼凑面額動態規劃 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] num = new int[] { 1, 5, 10, 20, 50, 100 };
		long[] dp = new long[n + 1];//important!
		dp[0] = 1;
		for (int i = 0; i < num.length; i++) {
			for (int j = num[i]; j <= n; j++) {
				dp[j] += dp[j - num[i]];
			}
		}
		System.out.println(dp[n]);
	}
}
