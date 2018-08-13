package 字节跳动;

import java.util.Scanner;

public class One {
	private static Scanner sc;
	private static int count = 0;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] split = str.split(",");
		int m = Integer.parseInt(split[0]);
		int n = Integer.parseInt(split[1]);
		int[][] matrix = new int[m][n];
		for (int i = 0; i < m; i++) {
			String temp = sc.nextLine();
			String[] split2 = temp.split(",");
			for (int j = 0; j < n; j++) {
				matrix[i][j] = Integer.parseInt(split2[j]);
			}
		}

		int res = 0;
		int count = 0;
		for (int i = 0; i < m; ++i) {
			for (int j = 0; j < n; ++j) {
				if (matrix[i][j] == 1) {
					int tmp = helper(matrix, i, j);
					res = Math.max(res, tmp);
					count++;
				}
			}
		}
		System.out.println(count + "," + res);
	}

	public static int helper(int[][] matrix, int i, int j) {
		if (i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] != 1)
			return 0;
		matrix[i][j] = 0;
		return 1 + helper(matrix, i, j + 1) + helper(matrix, i, j - 1) + helper(matrix, i + 1, j)
				+ helper(matrix, i - 1, j) + helper(matrix, i - 1, j + 1) + helper(matrix, i - 1, j - 1)
				+ helper(matrix, i + 1, j - 1) + helper(matrix, i + 1, j + 1);
	}
}
