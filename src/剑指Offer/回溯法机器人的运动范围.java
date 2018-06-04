package 剑指Offer;

public class 回溯法机器人的运动范围 {

	public static int movingCount(int threshold, int rows, int cols) {
		int res = 0;
		boolean[] flag = new boolean[rows * cols];
		res = helper(0, 0, rows, cols, threshold, flag);
		return res;
	}

	private static int helper(int i, int j, int rows, int cols, int threshold, boolean[] flag) {
		int count = 0;
		if (i >= 0 && j >= 0 && i < rows && j < cols && check(i) + check(j) <= threshold
				&& flag[i * cols + j] == false) {
			flag[i * cols + j] = true;
			count = 1 + helper(i + 1, j, rows, cols, threshold, flag) + helper(i, j + 1, rows, cols, threshold, flag)
					+ helper(i - 1, j, rows, cols, threshold, flag) + helper(i, j - 1, rows, cols, threshold, flag);

		}
		return count;
	}

	static int check(int n) {
		int res = 0;
		while (n != 0) {
			res += n % 10;
			n /= 10;
		}
		return res;
	}
}
