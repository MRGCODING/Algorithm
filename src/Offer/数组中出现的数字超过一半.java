package Offer;

import java.util.Arrays;

public class 数组中出现的数字超过一半 {
	/**
	 * 如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。 在遍历数组时保存两个值：一是数组中一个数字，一是次数。
	 * 遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；若次数为0，则保存下一个数字，并将次数置为1。遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。
	 * 
	 * @param array
	 * @return
	 */
	public static int MoreThanHalfNum_Solution(int[] array) {
		int res = 0;
		int k = array[0];
		for (int i = 0; i < array.length; i++) {
			if (res == 0) {
				k = array[i];
				res = 1;
			}
			if (array[i] == k)
				res++;
			else
				res--;
		}
		res = 0;
		for (int i = 0; i < array.length; i++)
			if (k == array[i])
				res++;
		return res > array.length / 2 ? res : 0;
	}

	/**
	 * 数组排序后，如果符合条件的数存在，则一定是数组中间那个数。（比如：1，2，2，2，3；或2，2，2，3，4；或2，3，4，4，4等等）
	 * 这种方法虽然容易理解，但由于涉及到快排sort，其时间复杂度为O(NlogN)并非最优；
	 * 
	 */
	int MoreThanHalfNum_Solution1(int[] numbers) {
		// 因为用到了sort，时间复杂度O(NlogN)，并非最优
		if (numbers.length == 0)
			return 0;

		Arrays.sort(numbers); // 排序，取数组中间那个数
		int middle = numbers[numbers.length / 2];

		int count = 0; // 出现次数
		for (int i = 0; i < numbers.length; ++i) {
			if (numbers[i] == middle)
				++count;
		}

		return (count > numbers.length / 2) ? middle : 0;
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 2, 2, 2, 5, 4, 2 };
		int moreThanHalfNum_Solution = MoreThanHalfNum_Solution(array);
		System.out.println(moreThanHalfNum_Solution);
	}
}
