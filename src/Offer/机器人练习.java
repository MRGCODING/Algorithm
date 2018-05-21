package Offer;

public class 机器人练习 {
	public static int movingCount(int threshold, int rows, int cols) {
		boolean[] flag = new boolean[rows * cols];
		int count = helper(threshold, 0, 0, rows, cols, flag);
		return count;
	}

	private static int helper(int threshold, int i, int j, int rows, int cols, boolean[] flag) {
		int count = 0;
		if (check(threshold, i, j, rows, cols, flag)) {
			count = 1 + helper(threshold, i, j + 1, rows, cols, flag) + helper(threshold, i, j - 1, rows, cols, flag)
					+ helper(threshold, i - 1, j, rows, cols, flag) + helper(threshold, i + 1, j, rows, cols, flag);
		}
		return count;
	}

	private static boolean check(int threshold, int i, int j, int rows, int cols, boolean[] flag) {
		if (i >= 0 && j >= 0 && i < rows && j < cols && !flag[i * rows + j] && Count(i) + Count(j) < threshold)
			return true;
		return false;
	}

	private static int Count(int i) {
		int res = 0;
		while (i != 0) {
			res += i % 10;
			i /= 10;
		}
		return res;
	}
}
