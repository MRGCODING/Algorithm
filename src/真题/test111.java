package 真题;

import java.util.Scanner;

public class test111 {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int n, k;
		int[] a = new int[10];
		String str;
		StringBuilder sb = null;

		n = scanner.nextInt();
		k = scanner.nextInt();
		scanner.nextLine();
		str = scanner.nextLine();

		char[] c = str.toCharArray();

		for (int i = 0; i < c.length; i++) {
			a[c[i] - '0']++;
		}

		int min, cc, ci, ck;
		int[] s;
		min = Integer.MAX_VALUE;

		for (int i = 0; i < 10; i++) {
			if (a[i] == 0) {
				continue;
			}
			cc = 0;
			ci = 1;
			ck = k - a[i];
			s = new int[10];
			while (ck > 0) {
				if (i - ci >= 0 && a[i - ci] > 0) {
					if (ck > a[i - ci]) {
						cc += ci * a[i - ci];
						ck -= a[i - ci];
						s[i - ci] = a[i - ci];
					} else {
						cc += ci * ck;
						s[i - ci] = ck;
						ck = 0;
					}
				}
				if (ck > 0 && i + ci <= 9 && a[i + ci] > 0) {
					if (ck > a[i + ci]) {
						cc += ci * a[i + ci];
						ck -= a[i + ci];
						s[i + ci] = a[i + ci];
					} else {
						cc += ci * ck;
						s[i + ci] = ck;
						ck = 0;
					}
				}
				ci++;
			}
			if (cc < min) {
				min = cc;

				sb = new StringBuilder();
				for (char tc : c) {
					if (s[tc - '0'] > 0) {
						sb.append(i);
						s[tc - '0']--;
					} else {
						sb.append(tc);
					}
				}

			}
		}

		System.out.println(min);
		System.out.println(sb.toString());

	}

}
