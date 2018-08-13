package 字节跳动;

import java.util.Scanner;

public class Three {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		System.out.println(helper(n, x, y));
	}

	private static int helper(int n, int[] x, int[] y) {
		int MV = 123456;
		int[][][] dp = new int[2][2][MV];
		int now = 0, pre = 1;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < MV; j++) {
				dp[now][i][j] = Integer.MIN_VALUE;
			}
		}
		dp[now][0][0] = 0;
		for (int i = 0; i < n; i++) {
			int temp = pre;
			pre = now;
			now = temp;
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < MV; k++) {
					dp[now][j][k] = Integer.MIN_VALUE;
				}
			}
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < MV; k++) {
					if (dp[pre][j][k] == Integer.MIN_VALUE) {
						continue;
					}
					dp[now][j][k] = dp[now][j][k] > dp[pre][j][k] ? dp[now][j][k] : dp[pre][j][k];
					int value = k;
					if (j == 0) {
						value = -value;
					}
					check(value + x[i], now, dp[pre][j][k] + y[i], dp);
					check(value - x[i], now, dp[pre][j][k] + y[i], dp);
				}
			}
		}
		return dp[now][0][0];
	}

	private static void check(int value, int cur, int score, int[][][] dp) {
		int i = 0;
		int j = value;
		if (value < 0) {
			i = 1;
			j = -j;
		}
		dp[cur][i][j] = dp[cur][i][j] > score ? dp[cur][i][j] : score;
	}
}
