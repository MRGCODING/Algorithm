package niuke2017;

import java.util.Scanner;

public class 计算糖果 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int ab1 = sc.nextInt();
			int ab2 = sc.nextInt();
			int bc1 = sc.nextInt();
			int bc2 = sc.nextInt();
			int a = (ab1 + bc1) / 2;
			int b = (ab2 + bc2) / 2;
			int check = (bc1 - ab1) / 2;
			int c = (bc2 - ab2) / 2;
			if (check == b)
				System.out.println(a + " " + b + " " + c);
			else
				System.out.println("No");
		}
	}
}
