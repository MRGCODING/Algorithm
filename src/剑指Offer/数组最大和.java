package 剑指Offer;

public class 数组最大和 {
	public int FindGreatestSumOfSubArray(int[] array) {
		int res = array[0], temp = array[0];
		for (int i = 1; i < array.length; i++) {
			if (temp < 0)
				temp = array[i];
			else
				temp += array[i];
			res = Math.max(res, temp);
		}
		return res;
	}
}
