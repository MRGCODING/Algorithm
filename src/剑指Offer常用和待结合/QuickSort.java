package 剑指Offer常用和待结合;

public class QuickSort {
	void QuickSort(int[] num, int l, int r) {
		if (l < r) {
			int q = Partition(num, l, r);
			QuickSort(num, l, q - 1);
			QuickSort(num, q + 1, r);
		}
	}

	// 快排一次划分
	int Partition(int[] num, int l, int r) {
		int i = l, j = r;
		int temp = num[l];
		while (true) {
			while (num[++i] < temp && i < r)
				;
			while (num[--j] > temp)
				;
			if (i >= j)
				break;
			swap(num, i, j);
		}
		num[l] = num[j];
		num[j] = temp;
		return j;
	}

	private void swap(int[] num, int i, int j) {
		int temp = num[i];
		num[i] = num[j];
		num[j] = temp;
	}
}
