package niuke2017;

import java.util.Scanner;

public class 暗黑的字符串DP {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		long[] dp = new long[w + 1];
		dp[1] = 3;
		dp[2] = 9;
		for(int i = 3;i <= w;i++){
			dp[i] = 2 * dp[i - 1] + dp[i - 2];
		}
		System.out.println(dp[w]);
	}
}
