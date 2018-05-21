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
		if (i < 0 || i >= rows || j < 0 || j >= cols || matrix[i * cols + j] != str[length] || flag[i * cols + j])
            return false;
        if(length == str.length - 1)
            return true;
        boolean check = false;
		if (i >= 0 && i < rows && j >= 0 && j < cols && str[length] == matrix[i * cols + j] && flag[i * cols + j] == false) {
			++length;
            flag[i * cols + j] = true;
            check = helper(matrix, rows, cols, i + 1, j, str, length, flag)
                || helper(matrix, rows, cols, i - 1, j, str, length, flag)
                || helper(matrix, rows, cols, i, j - 1, str, length, flag)
                || helper(matrix, rows, cols, i, j + 1, str, length, flag);
            if (check == false) {
				--length;
				flag[i * cols + j] = false;
			}
		}
		return check;
	}
}
