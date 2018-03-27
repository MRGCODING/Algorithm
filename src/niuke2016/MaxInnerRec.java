package niuke2016;

import java.util.Stack;

public class MaxInnerRec {
	public int countArea(int[] A, int n) {
		Stack<Integer> s = new Stack<>();
		int res = 0,max = 0;
		for (int i = 0; i < A.length; i++) {
			if (s.empty() || A[i] > A[i - 1])
				s.push(i);
			else {
				max = A[i] * (i - s.peek() + 1);
				s.pop();
			}
		}
		return res;
	}

	public static void main(String[] args) {
		MaxInnerRec maxInnerRec = new MaxInnerRec();
		int[] A = { 2, 7, 9, 4, 1 };
		maxInnerRec.countArea(A, 5);
	}
}
