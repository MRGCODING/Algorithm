package 网易互娱;

import java.util.HashMap;
import java.util.Scanner;

public class Three {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int t = sc.nextInt();
		int res = 0;
		while (t-- != 0) {
			int q = sc.nextInt();
			int n = sc.nextInt();
			int m = sc.nextInt();

			int rankScore = sc.nextInt();
			HashMap<Integer, Integer> mapper1 = new HashMap<>();
			HashMap<HashMap<Integer, Integer>, Integer> map1 = new HashMap<>();

			int[] killScores = new int[m + 1];

			HashMap<String, String> mapper2 = new HashMap<>();
			HashMap<Integer, HashMap<String, String>> map2 = new HashMap<>();

			while (n-- != 0) {
				int l = sc.nextInt();
				int r = sc.nextInt();
				mapper1.put(l, r);
				map1.put(mapper1, rankScore);
			}
			for (int i = 0; i <= m; i++) {
				int killScore = sc.nextInt();
				killScores[i - 1] = killScore;
			}
			int a = sc.nextInt();
			int b = sc.nextInt();
			for (int i = 1; i < q; i++) {
				String str = sc.nextLine();
				String[] split = str.split(" ");
				int time = Integer.parseInt(split[0]);
				String killer = split[1];
				String victim = split[2];
				mapper2.put(killer, victim);
				map2.put(time, mapper2);
			}
		}
	}
}
