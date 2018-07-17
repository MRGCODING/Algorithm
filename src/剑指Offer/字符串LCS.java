package 剑指Offer;

public class 字符串LCS {
	public int findLCS(String A, int n, String B, int m) {
		// write code here
		char[] a = A.toCharArray();
		char[] b = B.toCharArray();
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; ++i) {
			for (int j = 1; j <= m; ++j) {
				if (a[i - 1] == b[j - 1]) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[n][m];
	}
}
