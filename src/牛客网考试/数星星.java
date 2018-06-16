package 牛客网考试;

import java.util.ArrayList;
import java.util.Scanner;

public class 数星星 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		ArrayList<ArrayList<Integer>> stars = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			ArrayList<Integer> temp = new ArrayList<>();
			temp.add(sc.nextInt());
			temp.add(sc.nextInt());
			stars.add(temp);
		}
		int count = 0;
		int m = sc.nextInt();
		for (int i = 0; i < m; i++) {
			int a1 = sc.nextInt();
			int b1 = sc.nextInt();
			int a2 = sc.nextInt();
			int b2 = sc.nextInt();
			for (int l = 0; l < stars.size(); l++) {
				int aa = stars.get(l).get(0);
				int bb = stars.get(l).get(1);
				if (aa >= a1 && aa <= a2 && bb >= b1 && bb <= b2) {
					count++;
				}
			}

			System.out.println(count);
			count = 0;
		}
	}
}
