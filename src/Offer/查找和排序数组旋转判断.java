package Offer;

public class 查找和排序数组旋转判断 {
	public int minNumberInRotateArray(int[] array) {
		if (array.length == 0)
			return 0;
		int flag = -1;
		for (int i = 0; i < array.length; i++)
			if (array[i] > array[i + 1]) {
				flag = i;
				break;
			}
		if (flag != -1) {
			return array[flag + 1];
		}
		return 0;
	}
}
