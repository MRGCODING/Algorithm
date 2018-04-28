package niuke2017;

import java.util.Scanner;

public class 截取字符串比长度之彩色宝石项链搜狐 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] ca = str.toCharArray();
		int len = str.length();
		for (int x = 5; x < len; x++) { // x为截取宝石的个数
			for (int y = 0; y < len; y++) {// y为x确定的情况下迭代的次数
				StringBuffer temp = new StringBuffer("");
				for (int z = y; z < y + x; z++) {
					temp.append(ca[z % len]);
				}
				String t = temp.toString();
				if (t.contains("A") && t.contains("B") && t.contains("C") && t.contains("D") && t.contains("E")) {
					System.out.println(len - x);
					return;
				}
			}
		}
	}
}
