package Offer;

public class 机器人上下左右 {
	public static int Count(int num) {
		int res = 0;
		while (num != 0) {
			res += num % 10;
			num /= 10;
		}
		return res;
	}

	public static boolean check(int threshold, int rows, int cols, int i, int j, boolean[] flag) {
		if (i < rows && j < cols && i >= 0 && j >= 0 && flag[i * cols + j] == false && Count(i) + Count(j) <= threshold)
			return true;
		else
			return false;
	}

	public static int helper(int threshold, int rows, int cols, int i, int j, boolean[] flag) {
		int count = 0;
		if (check(threshold, rows, cols, i, j, flag)) {
			flag[i * cols + j] = true;
			count = 1 + helper(threshold, rows, cols, i - 1, j, flag) + helper(threshold, rows, cols, i, j - 1, flag)
					+ helper(threshold, rows, cols, i + 1, j, flag) + helper(threshold, rows, cols, i, j + 1, flag);
		}
		return count;
	}

	public static int movingCount(int threshold, int rows, int cols) {
		boolean[] flag = new boolean[rows * cols];
		for (int i = 0; i < rows * cols; i++)
			flag[i] = false;
		int count = helper(threshold, rows, cols, 0, 0, flag);
		return count;
	}

	public static void main(String[] args) {
		int movingCount = movingCount(5, 10, 10);
		System.out.println(movingCount);
	}
}
