package 剑指Offer常用和待结合;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 餐厅 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] a = new int[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextInt();
		int[][] bc = new int[m][2];
		for (int i = 0; i < m; i++) {
			bc[i][0] = sc.nextInt();
			bc[i][1] = sc.nextInt();
		}
		Arrays.sort(a);
		Arrays.sort(bc, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o2[1] - o1[1];
			}
		});
		boolean[] flag = new boolean[n];
		long res = 0;
		for (int i = 0; i < m; i++) {
			if (bc[i][0] > a[n - 1])
				continue;
			int index = helper(a, bc[i][0]);
			while (index < n && flag[index])
				index++;
			if (index < n) {
				res += bc[i][1];
				flag[index] = true;
			}

		}
		System.out.println(res);
	}

	private static int helper(int[] a, int target) {
		int left = 0, right = a.length - 1, mid = 0;
		while (left <= right) {
			mid = (left + right) >> 1;
			if (a[mid] >= target)
				right = mid - 1;
			else
				left = mid + 1;

		}
		return left;
	}
}