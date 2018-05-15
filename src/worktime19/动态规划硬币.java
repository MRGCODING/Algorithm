package worktime19;

import java.util.Scanner;

/**
 * 硬币兑换的种数
 * @author Lenovo
 *
 */
public class 动态规划硬币 {

	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);

		int t, n, k;
		int[] v;

		t = scanner.nextInt();

		for (int i = 0; i < t; i++) {
			n = scanner.nextInt();
			k = scanner.nextInt();
			v = new int[n];
			for (int j = 0; j < n; j++) {
				v[j] = scanner.nextInt();
			}
			System.out.println(helper(v, k));
		}

	}

	public static long helper(int[] v, int k) {
		long[] dp = new long[k + 1];
		dp[0] = 1;
		for (int i = 0; i < v.length; i++) {
			//注意到和0-1背包的不同之处
			for (int j = v[i]; j <= k; j++) {
				dp[j] = (dp[j] + dp[j - v[i]]);// % 100000007
			}
		}
		return dp[k];// % 100000007;
	}
}
