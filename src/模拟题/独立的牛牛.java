package 模拟题;

import java.util.Scanner;

public class 独立的牛牛 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int x = sc.nextInt();
		int f = sc.nextInt();
		int d = sc.nextInt();
		int p = sc.nextInt();
		if (d / x < x * f) {
			System.out.println(d / x);
			return;
		} else if (d / x == f) {
			System.out.println(f);
			return;
		} else {
			int money = d - x * f;
			int day = f + money / (x + p);
			System.out.println(day);
		}
	}
}
