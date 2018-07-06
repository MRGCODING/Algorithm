package 剑指Offer;

import java.util.Arrays;

public class 二叉搜索树的后序遍历 {
	public boolean VerifySquenceOfBST(int[] sequence) {
		if (sequence.length == 0)
			return false;
		int root = sequence[sequence.length - 1];
		int i = 0;
		for (; i < sequence.length - 1; i++) {
			if (sequence[i] > root)
				break;
		}
		int j = i;
		for (; j < sequence.length - 1; j++) {
			if (sequence[j] < root)
				return false;
		}
		boolean left = true;
		if (i > 0)
			left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
		boolean right = true;
		if (i < sequence.length - 1)
			right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, sequence.length - 1));
		return (left && right);
	}
}