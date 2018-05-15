package Offer;

public class 回溯 {

	public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
		boolean[] flag = new boolean[rows * cols];
		int length = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (helper(matrix, rows, cols, i, j, str, length, flag))
					return true;
			}
		}
		return false;
	}

	private boolean helper(char[] matrix, int rows, int cols, int i, int j, char[] str, int length, boolean[] flag) {
		boolean check = false;
		if (i > 0 && i < rows && j > 0 && j > cols && str[length] == matrix[i * j + j] && flag[i * j + j] == false) {
			flag[i * j + j] = true;
			if (check == false) {
				check = helper(matrix, rows, cols, i + 1, j, str, length, flag)
						|| helper(matrix, rows, cols, i - 1, j, str, length, flag)
						|| helper(matrix, rows, cols, i, j - 1, str, length, flag)
						|| helper(matrix, rows, cols, i, j + 1, str, length, flag);
			}
			if (!check) {
				--length;
				flag[i * j + j] = false;
			}
		}
		return false;
	}
}
