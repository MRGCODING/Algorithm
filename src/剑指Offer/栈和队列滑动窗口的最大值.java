package 剑指Offer;

import java.util.ArrayList;

public class 栈和队列滑动窗口的最大值 {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < num.length;) {
			int max = num[i];
			for (int j = 0; j < 3; j++) {
				if (max < num[++i]) {
					max = num[i];
					i++;
				}
			}
			res.add(max);
		}
		return res;
	}
}
