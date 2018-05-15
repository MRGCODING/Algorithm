package niuke.今日头条;

import java.util.Scanner;

//TODO
public class 球队比赛 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while (num-- != 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int d1 = sc.nextInt();
			int d2 = sc.nextInt();
			if (n == k) {
				if (d1 == d2 && d1 == 0)
					System.out.println("yes");
				else
					System.out.println("no");
				continue;
			}
			if (d1 == d2 && d2 == 0) {
				System.out.println("yes");
				continue;
			}
			int count = n - k;
			if ((d1 + d2) % count == 0 || (d1 + d2) / count == 1)
				System.out.println("yes");
			else
				System.out.println("no");
		}
	}
}
