package Leetcode;

import java.util.Stack;

public class DailyTemperatures_739Stack {
	class Solution {
		public int[] dailyTemperatures(int[] temperatures) {
			Stack<Integer> stack = new Stack<>();
			int[] res = new int[temperatures.length];
			for (int i = 0; i < temperatures.length; i++) {
				while (!stack.isEmpty() && temperatures[i] < temperatures[stack.peek()]) {
					int ret = stack.pop();
					res[ret] = i - ret;
				}
				stack.push(i);
			}
			return res;
		}
	}
}
