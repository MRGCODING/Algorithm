package 牛客网刷题;

import java.util.Scanner;

public class 路灯 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = Integer.parseInt(sc.nextLine());
		for (int j = 0; j < t; j++) {
			int n = Integer.parseInt(sc.nextLine());
			String str = sc.nextLine();
			int count = 0;
			for (int i = 0; i < str.length(); i++) {
				if (str.charAt(i) == '.'){
					i = i + 2;
					count++;
				}
			}
			System.out.println(count);
		}
	}
}
