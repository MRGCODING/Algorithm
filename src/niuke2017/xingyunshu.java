package niuke2017;

import java.util.Scanner;

public class xingyunshu {
	static int CountTen(int num) {
		int res = 0;
		while (num != 0) {
			res += num % 10;
			num /= 10;
		}
		return res;
	}
	static int CountTwo(int num) {
		int res = 0;
		while (num != 0) {
			res += num % 2;
			num /= 2;
		}
		return res;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int count = 0;
		for (int i = 1; i <= num; i++) {
			if (CountTen(i) == CountTwo(i))
				count++;
		}
		System.out.println(count);
	}
}
