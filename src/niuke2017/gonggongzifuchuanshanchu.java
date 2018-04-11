package niuke2017;

import java.util.Scanner;

public class gonggongzifuchuanshanchu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str1 = sc.nextLine();
			String str2 = sc.nextLine();
			StringBuilder str = new StringBuilder();
			for (int i = 0; i < str1.length(); i++) {
				char c = str1.charAt(i);
				if (str2.indexOf(c) == -1) {
					str.append(c);
				}
			}
			System.out.println(str.toString());
		}
	}
}
