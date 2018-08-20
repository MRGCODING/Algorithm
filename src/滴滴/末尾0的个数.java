package 滴滴;

import java.util.Scanner;

public class 末尾0的个数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = 0;
		while (n / 5 != 0) {
			n = n / 5;
			res += n;
		}
		System.out.println(res);
	}
}
