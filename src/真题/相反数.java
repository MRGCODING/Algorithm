package 真题;

import java.util.Scanner;

public class 相反数 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = Integer.parseInt(new StringBuffer(n + "").reverse().toString()) + n;
		System.out.println(res);
	}
}
