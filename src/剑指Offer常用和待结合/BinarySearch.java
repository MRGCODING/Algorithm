package 剑指Offer常用和待结合;

public class BinarySearch {
	public int BinarSearch(int[] num, int x, int n) {
		int l = 0, r = n - 1;
		while (l <= r) {
			int m = l + (r - l) / 2;
			if (x == num[m])
				return m;
			else if (x > num[m])
				l = m + 1;
			else
				r = m - 1;
		}
		return -1;
	}
}
