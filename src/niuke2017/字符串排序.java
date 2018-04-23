package niuke2017;
 

import java.util.Scanner;

public class 字符串排序 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = Integer.parseInt(sc.nextLine());
		String[] str = new String[num];
		for (int i = 0; i < num; i++) {
			str[i] = sc.nextLine();
		}
		if (sort1(str) && sort2(str)) {
			System.out.println("both");
			return;
		} else if (sort1(str) && !sort2(str)) {
			System.out.println("lexicographically");
			return;
		} else if (!sort1(str) && sort2(str)) {
			System.out.println("lengths");
			return;
		} else {
			System.out.println("none");
			return;
		}
	}

	private static boolean sort2(String[] str) {
		for (int i = 0; i < str.length - 1; i++) {
			if (str[i].length() > str[i + 1].length())
				return false;
		}
		return true;
	}

	private static boolean sort1(String[] str) {
		for (int i = 1; i < str.length; i++) {
			if (str[i].compareTo(str[i - 1]) < 0)
				return false;
		}
		return true;
	}
}
