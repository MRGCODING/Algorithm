package niuke.网易实习;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 牛牛找工作 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		Map<Integer, Integer> work = new HashMap<Integer, Integer>();
		int[] dif = new int[n + m];
		int[] power = new int[m];
		for (int i = 0; i < n; i++) {
			int temp = sc.nextInt();
			dif[i] = temp;
			work.put(temp, sc.nextInt());
		}
		for (int i = 0; i < m; i++) {
			dif[i + n] = sc.nextInt();
			power[i] = dif[i + n];
			if (!work.containsKey(power[i])) {
				work.put(power[i], 0);
			}
		}
		Arrays.sort(dif);
		int temp = 0;
		for (int i = 0; i < dif.length; i++) {
			temp = Math.max(temp, work.get(dif[i]));
			work.put(dif[i], temp);
		}
		for (int i = 0; i < m; i++) {
			System.out.println(work.get(power[i]));
		}
	}
}
