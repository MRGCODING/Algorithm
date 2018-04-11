package niuke2017;

import java.util.Scanner;

public class sushudui {
	static boolean isRight(int num) {
		if(num == 2)
			return false;
		for (int i = 2; i < num; i++) {
			if (num % i == 0)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (sc.hasNext()) {
			int num = sc.nextInt();
			for (int i = 1; i <= num; i++) {
				if (!isRight(i))
					continue;
				for (int j = i; j <= num; j++) {
					if (!isRight(j))
						continue;
					if (i + j == num)
						count++;
				}
			}
			System.out.println(count);
		}
	}
}
