package niuke2017;

import java.util.Scanner;

public class Fibonacci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int l = 0, r = 1;
		while (r < n) {
			int temp = l;
			l = r;
			r = temp + l;
		}
		System.out.println(Math.min(n - l, r - n));
	}
}
