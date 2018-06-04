package 剑指Offer;

public class 回溯法矩阵中的路径 {
	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		boolean[] flag = new boolean[rows * cols];
		int count = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (helper(i, j, rows, cols, flag, matrix, str, count))
					return true;
			}
		}
		return false;
	}

	private boolean helper(int i, int j, int rows, int cols, boolean[] flag, char[] matrix, char[] str, int count) {
		if (i < 0 || j < 0 || i >= rows || j >= cols || matrix[i * cols + j] != str[count] || flag[i * cols + j])
			return false;
		if (count == str.length - 1)
			return true;
		boolean res = false;
		if (i >= 0 && j >= 0 && i < rows && j < cols && flag[i * cols + j] == false && count <= str.length
				&& matrix[i * cols + j] == str[count]) {
			flag[i * cols + j] = true;
			count++;
			res = helper(i + 1, j, rows, cols, flag, matrix, str, count)
					|| helper(i - 1, j, rows, cols, flag, matrix, str, count)
					|| helper(i, j + 1, rows, cols, flag, matrix, str, count)
					|| helper(i, j - 1, rows, cols, flag, matrix, str, count);
		}
		if (res != true) {
			flag[i * cols + j] = false;
			count--;
		}
		return res;
	}
}
