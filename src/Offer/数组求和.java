package Offer;

import java.util.HashMap;
import java.util.Map;

public class 数组求和 {
	public int[] twoSum(int[] nums, int target) {
		int res[] = new int[2];
		Map<Integer, Integer> m = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (m.containsKey(target - nums[i])) {
				res[0] = m.get(target - nums[i]);
				res[1] = i;
				return res;
			}
			m.put(nums[i], i);
		}
		return res;
	}

	public static void main(String[] args) {

	}
}
