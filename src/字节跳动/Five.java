package 字节跳动;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

public class Five {
	private static Scanner sc;

	public static class Pair {
		public int s;
		public int t;

		public Pair(int s, int t) {
			this.s = s;
			this.t = t;
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Pair> temp = new ArrayList<>();
		ArrayList<Pair> res = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			if (y < x)
				y += m;
			temp.add(new Pair(x, y));
		}
		Comparator<Pair> comparator = new Comparator<Pair>() {
			@Override
			public int compare(Pair o1, Pair o2) {
				return o1.t - o2.t;
			}
		};
		temp.sort(comparator);
		for (int i = 0; i < n; i++) {
			if (i == 0 || res.get(res.size() - 1).t <= temp.get(i).s) {
				if (temp.get(i).t >= m) {
					temp.get(i).t -= m;
					if (temp.get(i).t <= res.get(0).s) {
						res.add(temp.get(i));
						break;
					}
				} else
					res.add(temp.get(i));
			}
		}
		System.out.println(res.size());
	}
}