package niuke2017;

import java.util.Arrays;
import java.util.Scanner;

public class 分苹果 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] a = new int[n];
		int sum = 0;
		int res = 0;
		for (int i = 0; i < n; i++) {
			a[i] = sc.nextInt();
			sum += a[i];
		}
		if (sum % n != 0) {
			System.out.println("-1");
			return;
		}
		int avg = sum / n;
		for (int i = 0; i < n; i++) {
			if (Math.abs(a[i] - avg) % 2 != 0) {
				System.out.println("-1");
				return;
			}
		}
		for (int i = 0; i < n; i++) {
			if (a[i] < avg)
				res += (avg - a[i]) / 2;
		}
		System.out.println(res);
	}
}
