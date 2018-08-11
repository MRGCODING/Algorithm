package 网易互联网;

import java.util.Arrays;
import java.util.Scanner;

public class TwoM {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int helper[] = new int[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			count += a[i];
			helper[i] = count;
		}
		int m = sc.nextInt();
		int[] q = new int[m];
		for (int j = 0; j < m; j++)
			q[j] = sc.nextInt();
		for (int i = 0; i < m; i++) {
			System.out.println(helper(q[i], helper, n));
		}
	}

	private static int helper(int q, int[] helper, int length) {
		int left = 0, right = length - 1;
		int mid = 0;
		while (left < right) {
			mid = left + (right - left) / 2;
			if(helper[mid] == q)
				return mid + 1;
			else if(helper[mid] < q)
				left = mid + 1;
			else right = mid;
		}
		return left + 1;
	}
}
