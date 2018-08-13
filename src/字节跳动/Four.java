package 字节跳动;

import java.util.Scanner;

public class Four {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] a = new long[n];
		long[] b = new long[n];
		for (int i = 0; i < n; i++)
			a[i] = sc.nextLong();
		for (int i = 0; i < n; i++)
			b[i] = sc.nextLong();
		System.out.println(helper(n, a, b));
	}

	private static long helper(int n, long[] a, long[] b) {
		long res = 0, max = 0, min = 0;
		for (int i = 0; i < n; i++) {
			max = a[i];
			min = b[i];
			if (max < min)
				res++;
			for (int j = i + 1; j < n; j++) {
				max = Math.max(max, a[j]);
				min = Math.min(min, b[j]);
				if (max < min) 
					res++;
			}
		}
		return res;
	}
}
