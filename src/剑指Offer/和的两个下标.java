package 剑指Offer;

import java.util.HashMap;
import java.util.Map;

public class 和的两个下标 {
	public int[] getTwo2(int[] nums, int target) {
		int[] result = new int[2];
		Map<Integer, Integer> map = new HashMap<>(2);
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				result = new int[] { map.get(nums[i]), i };
			}
			map.put(target - nums[i], i);
		}
		return result;
	}
}
