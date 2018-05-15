package niuke.网易实习;

import java.util.Scanner;

public class 闹钟 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] hours = new int[n];
		int[] minits = new int[n];
		int[] res = new int[n];
		for (int i = 0; i < n; i++) {
			hours[i] = sc.nextInt();
			minits[i] = sc.nextInt();
			res[i] = hours[i] * 60 + minits[i];
		}
		int wayTime = sc.nextInt();
		int hoursEnd = sc.nextInt();
		int minitsEnd = sc.nextInt();
		int temp = hoursEnd * 60 + minitsEnd - wayTime;
		int flag = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++) {
			if (temp - res[i] < 0) {
				continue;
			} else {
				if (res[i] > flag) {
					flag = res[i];
				}
			}
		}
		System.out.println(flag / 60 + " " + flag % 60);
	}
}