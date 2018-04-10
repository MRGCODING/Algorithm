package niuke2017;

import java.util.Arrays;
import java.util.Scanner;

public class maipingguo {
	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int num = sc.nextInt();
			int[] dp = new int[num + 1];
			dp[0] = 0;
			Arrays.fill(dp, 1, num + 1, Integer.MAX_VALUE);
			int[] packages = { 6, 8 };
			for (int i = 0; i < dp.length; i++) {
				if (dp[i] == Integer.MAX_VALUE)
					continue;
				for (int j = 0; j < packages.length; j++) {
					int temp = packages[j];
					if (i + temp <= num)
						dp[i + temp] = Math.min(dp[i + temp], dp[i] + 1);
				}
			}
			if (dp[num] == Integer.MAX_VALUE)
				System.out.println("-1");
			else
				System.out.println(dp[num]);
		}
	}
}
