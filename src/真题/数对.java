package 真题;

import java.util.Scanner;

public class 数对 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int res = 0;
		for (int i = 0; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i % j >= k) {
					res++;
				}
			}
		}
		System.out.println(res);
	}
}
