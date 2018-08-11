package 网易互娱;

import java.util.Scanner;

public class One {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		while (n-- != 0) {
			double res = 0;
			int money = sc.nextInt();
			if (money < 5000) {
				System.out.println(0);
				continue;
			} else {
				money = money - 5000;
				if (money < 3000) {
					res = (money - 0) * 0.03;
				} else if (money >= 3000 && money < 12000) {
					res = (3000 - 0) * 0.03 + (money - 3000) * 0.1;
				} else if (money >= 12000 && money < 25000) {
					res = (3000 - 0) * 0.03 + (12000 - 3000) * 0.1 + (money - 12000) * 0.2;
				} else if (money >= 25000 && money < 35000) {
					res = (3000 - 0) * 0.03 + (12000 - 3000) * 0.1 + (25000 - 12000) * 0.2 + (money - 25000) * 0.25;
				} else if (money >= 35000 && money < 55000) {
					res = (3000 - 0) * 0.03 + (12000 - 3000) * 0.1 + (25000 - 12000) * 0.2 + (35000 - 25000) * 0.25
							+ (money - 35000) * 0.3;
				} else if (money >= 55000 && money < 80000) {
					res = (3000 - 0) * 0.03 + (12000 - 3000) * 0.1 + (25000 - 12000) * 0.2 + (35000 - 25000) * 0.25
							+ (55000 - 35000) * 0.3 + (money - 55000) * 0.35;
				} else {
					res = (3000 - 0) * 0.03 + (12000 - 3000) * 0.1 + (25000 - 12000) * 0.2 + (35000 - 25000) * 0.25
							+ (55000 - 35000) * 0.3 + (80000 - 55000) * 0.35 + (money - 80000) * 0.45;
				}
			}
			int ress = (int) (res + 0.5);
			System.out.println(ress);
		}
	}
}
