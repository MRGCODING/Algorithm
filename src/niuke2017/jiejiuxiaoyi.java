package niuke2017;

import java.util.Scanner;

public class jiejiuxiaoyi {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res = 0;
		while (sc.hasNext()) {
			int n = sc.nextInt();
			int num[][] = new int[n][2];
			for (int i = 0; i < n; i++)
				num[i][0] = sc.nextInt();
			for (int i = 0; i < n; i++)
				num[i][1] = sc.nextInt();
			res = num[0][0] + num[0][1] - 2;
			for (int i = 1; i < n; i++) {
				int current = num[i][0] + num[i][1] - 2;
				if (res > current)
					res = current;
			}
			System.out.println(res);
		}
	}
}
