package 网易互娱;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Two {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		for (int i = 0; i < n; i++) {
			String str = sc.nextLine();
			if (helper1(str) && helper2(str) && helper3(str) && helper4(str) && helper5(str)) {
				System.out.println("yes");
			} else {
				System.out.println("no");
			}
		}
	}

	private static boolean helper1(String str) {
		if (str.length() < 8) {
			return false;
		}
		return true;
	}

	private static boolean helper2(String str) {
		char[] c = str.toCharArray();
		// boolean flag = true;
		int flag = 0;
		for (char cc : c) {
			if (small(cc)) {
				flag = 1;
				break;
			}
		}
		if (flag != 1) {
			return false;
		}
		for (char cc : c) {
			if (big(cc)) {
				flag = 2;
				break;
			}
		}
		if (flag != 2) {
			return false;
		}
		for (char cc : c) {
			if (num(cc)) {
				flag = 3;
				break;
			}
		}
		if (flag != 3) {
			return false;
		}
		for (char cc : c) {
			if (unbelivable(cc)) {
				flag = 4;
				break;
			}
		}
		if (flag != 4) {
			return false;
		}
		return true;
	}

	private static boolean helper3(String str) {
		char[] c = str.toCharArray();
		List<Character> list = new ArrayList<>();
		int n = 0;
		for (int i = 0; i < c.length; i++) {
			if (num(c[i])) {
				list.add(c[i]);
				n = list.size();
				if (n >= 3) {
					if (list.get(n - 1) - list.get(n - 2) == list.get(n - 2) - list.get(n - 3)) {
						return false;
					}
				}
			} else {//must!
				list = new ArrayList<>();
			}

		}
		return true;
	}

	private static boolean helper4(String str) {

		char[] c = str.toCharArray();
		int n = 0;
		List<Character> list1 = new ArrayList<>();
		List<Character> list2 = new ArrayList<>();
		for (int i = 0; i < c.length; i++) {
			if (small(c[i])) {
				list1.add(c[i]);
				list2 = new ArrayList<>();
				n = list1.size();
				if (n >= 3) {
					if (list1.get(n - 1) - list1.get(n - 2) == 1 && list1.get(n - 2) - list1.get(n - 3) == 1) {
						return false;
					}
				}
			} else if (big(c[i])) {
				list2.add(c[i]);
				list1 = new ArrayList<>();
				n = list2.size();
				if (n >= 3) {
					if (list2.get(n - 1) - list2.get(n - 2) == 1 && list2.get(n - 2) - list2.get(n - 3) == 1) {
						return false;
					}
				}
			} else {
				list1 = new ArrayList<>();
				list2 = new ArrayList<>();
			}
		}
		return true;
	}

	private static boolean helper5(String str) {
		String[] s = new String[] { "password", "admin", "qwerty", "hello", "iloveyou", "112233" };
		for (String cc : s) {
			if (str.contains(cc)) {
				return false;
			}
		}
		return true;
	}

	private static boolean small(char c) {
		if ('a' <= c && 'z' >= c) {
			return true;
		}
		return false;
	}

	private static boolean big(char c) {
		if ('A' <= c && 'Z' >= c) {
			return true;
		}
		return false;
	}

	private static boolean num(char c) {
		if ('0' <= c && '9' >= c) {
			return true;
		}
		return false;
	}

	private static boolean unbelivable(char c) {
		char[] cc = new char[] { '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '_', '-', '=', '+', '[', ']', '{',
				'}', ',', '.', '<', '>', '/', '?' };
		for (char ccc : cc) {
			if (ccc == c) {
				return true;
			}
		}
		return false;
	}
}
