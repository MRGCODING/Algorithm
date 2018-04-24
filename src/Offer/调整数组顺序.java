package Offer;

public class 调整数组顺序 {
	boolean isEven(int n) {
		if (n % 2 == 0)
			return true;
		return false;
	}

	// i,j两个指针，i找第一个偶数，j找第一个奇数，接着把i到j-1整体后移一位，j放到前面位置上
	public void reOrderArray(int[] array) {
		if (array == null || array.length == 0)
			return;
		int i = 0, j;
		while (i < array.length) {
			while (i < array.length && !isEven(array[i]))
				i++;
			j = i + 1;
			while (j < array.length && isEven(array[j]))
				j++;
			if (j < array.length) {
				int temp = array[j];
				for (int k = j - 1; k >= i; k--)
					array[k + 1] = array[k];
				array[i++] = temp;
			} else {
				break;
			}
		}
	}
}
