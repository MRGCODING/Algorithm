package Offer;

public class 连续子数组的最大值 {
	public int FindGreatestSumOfSubArray(int[] array) {
		int res = array[0], temp = array[0];
		for (int i = 1; i < array.length; i++) {
			if (temp < 0)
				temp = array[i];
			else
				temp += array[i];
			if(res < temp)
				res = temp;
		}
		return res;
	}

	public static void main(String[] args) {
		连续子数组的最大值 a = new 连续子数组的最大值();
		int[] arr = { 1, 2, 3 };
		int findGreatestSumOfSubArray = a.FindGreatestSumOfSubArray(arr);
		System.out.println(findGreatestSumOfSubArray);
	}
}
