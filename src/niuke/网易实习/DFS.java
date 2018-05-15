package niuke.网易实习;

import java.util.Scanner;

public class DFS {
	private static int count = 0;
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			count = 0;
			int n = scanner.nextInt();
			int w = scanner.nextInt();
			int[] v = new int[n];
			long sum = 0;
			for (int i = 0; i < n; i++) {
				v[i] = scanner.nextInt();
				sum += v[i];
			}
			if (sum <= w) {
				System.out.println((int) Math.pow(2, n));
			} else {
				dfs(0, 0, n, v, w);
				// 均不添加也是一种情况
				System.out.println(count + 1);
			}
		}
	}

	private static void dfs(long sum, int cur, int n, int[] v, int w) {
		if (cur < n) {
			if (sum > w) {
				return;
			}
			// 不添加这件零食
			dfs(sum, cur + 1, n, v, w);
			// 当前这种添加方式合理,添加这件零食
			if (sum + v[cur] <= w) {
				count++;
				dfs(sum + v[cur], cur + 1, n, v, w);
			}
		}
	}
}