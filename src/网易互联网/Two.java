package 网易互联网;

import java.util.Arrays;
import java.util.Scanner;

public class Two {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int count = 0;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			count += a[i];
		}
		int m = sc.nextInt();
		int[] q = new int[m];
		for (int j = 0; j < m; j++)
			q[j] = sc.nextInt();
		int[] helper = new int[count];
		int sum = 0, start = 0, end = 0;
		int flag = 1;
		for (int i = 0; i < n; i++) {
			start = sum;
			sum += a[i];
			end = sum;
			Arrays.fill(helper, start, end, flag);
			flag++;
		}
		for (int i = 0; i < m; i++) {
			System.out.println(helper[q[i] - 1]);
		}
	}
}
