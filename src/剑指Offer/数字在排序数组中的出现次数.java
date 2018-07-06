package 剑指Offer;

public class 数字在排序数组中的出现次数 {
	public int GetNumberOfK(int[] array, int k) {
		// int res = 0;
		// for (int i = 0; i < array.length; i++)
		// if (array[i] == k)
		// res++;
		// return res;
		int left = GetFirstNumberOfK(array, k);
		int right = GetLastNumberOfK(array, k);
		if (left != -1 && right != -1) {
			return right - left + 1;
		} else {
			return 0;
		}
	}

	private int GetFirstNumberOfK(int[] array, int k) {
		int left = 0, right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == k) {
				if (mid - 1 >= 0 && array[mid - 1] == k) {
					right = mid - 1;
				} else {
					return mid;
				}
			} else {
				left = mid + 1;
			}
		}
		return -1;
	}

	private int GetLastNumberOfK(int[] array, int k) {
		int left = 0, right = array.length - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			if (array[mid] == k) {
				if (mid + 1 < array.length && array[mid + 1] == k) {
					left = mid + 1;
				} else {
					return mid;
				}
			} else {
				right = mid - 1;
			}
		}
		return -1;
	}
}
