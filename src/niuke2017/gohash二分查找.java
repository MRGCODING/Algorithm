package niuke2017;

import java.util.Scanner;

public class gohash二分查找 {
	static int count = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String res = helper(-90, 90, n);
		System.out.println(res);
	}

	static String helper(int a, int b, int n) {
		String res = "";
		while (a <= b && count < 6) {
			count++;
			int mid = a + (b - a) / 2;
			if (mid <= n) {
				a = mid + 1;
				res += "1";
			} else {
				b = mid - 1;
				res += "0";
			}
		}
		return res;
	}
}
