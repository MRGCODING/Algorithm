package Offer;

import java.util.ArrayList;

public class 旋转遍历 {
	ArrayList<Integer> spiralOrder(int[][] matrix) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		int m = matrix.length, iDir = 0, im = 0, in = -1;
		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		if (m == 0)
			return res;
		int n = matrix[0].length;
		int[] nSteps = { n, m - 1 };
		while (nSteps[iDir % 2] != 0) {
			for (int i = 0; i < nSteps[iDir % 2]; i++) {
				im += dirs[iDir][0];
				in += dirs[iDir][1];
				res.add(matrix[im][in]);
			}
			nSteps[iDir % 2]--;
			iDir = (iDir + 1) % 4;
		}
		return res;
	}
}
