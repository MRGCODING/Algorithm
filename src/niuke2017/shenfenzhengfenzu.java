package niuke2017;

import java.util.Scanner;

public class shenfenzhengfenzu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			char s = str.charAt(i);
			if (s != ' '){
				System.out.print(s);
				count++;
			}
			if(i ==6 || i==15)
				System.out.print(" ");
		}
	}
}
