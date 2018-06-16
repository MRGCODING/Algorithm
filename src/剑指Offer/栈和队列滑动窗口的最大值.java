package 剑指Offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

/*
 * 当前滑动窗口的最大值判定：i - size + 1为窗口起始节点，和当前队列头比较，队列头小的话则不在当前窗口内需要出对，故采用双端队列
 */
public class 栈和队列滑动窗口的最大值 {
	public ArrayList<Integer> maxInWindows(int[] num, int size) {
		ArrayList<Integer> res = new ArrayList<>();
		ArrayDeque<Integer> temp = new ArrayDeque<>();
		if(size == 0)
			return res;//一定要加，否则无法通过全部的测试用例，这作为边界
		for (int i = 0; i < num.length; i++) {
			int begin = i - size + 1;
			if (temp.isEmpty()) {
				temp.add(i);
			} else if (begin > temp.peekFirst()) {
				temp.pollFirst();
			}
			while (!temp.isEmpty() && num[temp.peekLast()] <= num[i]) {
				temp.pollLast();
			}
			temp.add(i);
			if (begin >= 0)
				res.add(num[temp.peekFirst()]);
		}
		return res;
	}
}
