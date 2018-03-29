package Leetcode;

import java.util.Scanner;

public class IOTest {
	private static Scanner sc;

	public static void main(String[] args) {
		// in = new Scanner(System.in);
		// int a = in.nextInt();
		// int b = in.nextInt();
		// int c = in.nextInt();
		// int d = in.nextInt();
		// System.out.println(a + "," + b + "," + c + "," + d);

		sc = new Scanner(System.in);
		String[][] a = new String[2][];
		for (int i = 0; i < a.length; i++) {
			String[] b = sc.nextLine().split(" ");
			for (int j = 0; j < b.length; j++) {
				a[i] = b;
				// System.out.println(a[i][j]);
			}
		}
	}
}
