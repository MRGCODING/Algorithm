package niuke2017;

import java.util.Scanner;

public class shuixianhua {
	static int f(int x) {
		return x * x * x;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x = in.nextInt();
		int y = in.nextInt();
		int flag = 0;
		for (int i = x; i <= y; i++) {
			if ((f(i / 100) + f((i / 10) % 10) + f(i % 10)) == i) {
				if (flag == 0) {
					flag = 1;
					System.out.print(i);
				} else {
					System.out.print(i);
				}
			}

		}
		if (flag == 0) {
			System.out.print("no");
		}
	}
}
