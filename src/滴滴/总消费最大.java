package 滴滴;

import java.util.ArrayList;
import java.util.Scanner;

public class 总消费最大 {
	private static Scanner sc;

	class Pair {
		int x;
		int y;

		public Pair() {
		}

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		ArrayList<Pair> list = new ArrayList<>();

		for (int i = 0; i < n; i++) {
			int b = sc.nextInt();
			int c = sc.nextInt();
			list.add(new Pair(b, c));
			
		}
	}
}
