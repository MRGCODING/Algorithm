package Leetcode;

public class 最小数组长度 {
	public int minSubArrayLen(int s, int[] nums) {
		int res = Integer.MAX_VALUE;
		int count = 0;
		int fast = 0, slow = 0;
		while (fast < nums.length) {
			count += nums[fast++];
			while (slow < fast && count >= s) {
				res = Math.min(res, fast - slow);
				count -= nums[slow++];
			}
		}
		return res == Integer.MAX_VALUE ? 0 : res;
	}
}
