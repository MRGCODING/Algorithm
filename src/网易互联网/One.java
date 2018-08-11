package 网易互联网;

import java.util.Scanner;

public class One {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] point = new int[n];
		int[] alive = new int[n];
		for (int i = 0; i < n; i++) {
			point[i] = sc.nextInt();
		}
		for (int j = 0; j < n; j++)
			alive[j] = sc.nextInt();

		int temp = 0, count = 0, res = 0;
		for (int i = 0; i < k; i++)
			temp += point[i];
		for (int i = k; i < n; i++)
			if (alive[i] == 1)
				count += point[i];
		res = temp + count;
		int pointResult = res;
		for (int i = k; i < n; i++) {
			if (alive[i - k] == 0)
				res -= point[i - k];
			if (alive[i] == 0)
				res += point[i];
			if (res > pointResult)
				pointResult = res;
		}
		System.out.println(pointResult);
	}
}
