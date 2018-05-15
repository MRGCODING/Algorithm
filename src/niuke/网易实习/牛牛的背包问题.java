package niuke.网易实习;

import java.util.Scanner;

/**
 * https://blog.csdn.net/flushhip/article/details/79721659 ALL
 * https://www.nowcoder.com/questionTerminal/bf877f837467488692be703735db84e6 做法
 * @author Lenovo
 *
 */
public class 牛牛的背包问题 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int w = sc.nextInt();
		int[] v = new int[n];
		int sum = 0;
		for (int i = 0; i < n; i++) {
			v[i] = sc.nextInt();
			sum += v[i];
		}
		if (sum <= w) {
			System.out.println(2 * n);
			return;
		} else {
			dfs(-1, 0);
		}
		// int[] dp = new int[w + 1];
		// dp[0] = 1;
		// int count = 0;
		// for (int i = 0; i < v.length; i++) {
		// for (int j = v[i]; j <= w; j++) {
		// dp[j] += dp[j - v[i]];
		// }
		// }
		// System.out.println(dp[w]);
		// 实际为深搜，因为限制了数量

	}

	static void dfs(int t,int sum) {
		
	}
}
