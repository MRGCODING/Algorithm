package 携程;

import java.util.Scanner;

public class One {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextInt();
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) != 0)
				count++;
			flag = flag << 1;
		}
		System.out.println(count);
	}
}
