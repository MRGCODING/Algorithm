package niuke.网易实习;

import java.util.Scanner;

public class 被3整除 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int l = sc.nextInt();
		int r = sc.nextInt();
		int count = 0;
		for (int i = l; i <= r; i++) {
			if (Integer.parseInt(helper(i)) % 3 == 0) {
				count++;
			}
		}
		System.out.println(count);
	}

	static String helper(int n) {
		String res = "";
		for (int i = 1; i <= n; i++) {
			res += i;
		}
		return res;
	}
}
