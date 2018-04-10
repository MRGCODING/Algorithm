package niuke2017;

import java.util.Scanner;

public class shuzifanzhuan {
	static int Count(int num) {
		String s = String.valueOf(num);
		String res = new StringBuilder(s).reverse().toString();
		return Integer.parseInt(res);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int s1 = Count(x);
			int s2 = Count(y);
			System.out.println(Count(s1 + s2));
		}
	}
}
