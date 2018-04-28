package niuke2017;

import java.util.Scanner;

public class 进制转换算均值 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String[] res = new String[n - 2];
		// 转换进制
		for (int i = 2; i < n; i++) {
			res[i - 2] = change(n, i);
		}
		// 求和
		int countRes = 0;
		for (int i = 0; i < res.length; i++) {
			String[] split = res[i].split(",");
			for (String string : split) {
				countRes += Integer.parseInt(string);
			}
		}
		// 求均值
		int flo = 0;
		if (countRes % (n - 2) == 0) {
			countRes /= n - 2;
			flo = 1;
			System.out.println(countRes + "/" + flo);
			return;
		} else if (maxCount(countRes, n - 2) != 0) {
			int temp = maxCount(countRes, n - 2);
			System.out.println(countRes / temp + "/" + (n - 2) / temp);
			return;
		} else {
			System.out.println(countRes + "/" + (n - 2));
		}
	}

	static int maxCount(int a, int b) {
		int temp;
		if (a < b) {
			temp = a;
			a = b;
			b = temp;

		}
		while (a % b != 0) {
			temp = a % b;
			a = b;
			b = temp;
		}
		return b;
	}

	private static String change(int n, int i) {
		String res = "";
		while (n != 0) {
			res = n % i + "," + res;
			n /= i;
		}
		return res;
	}
}
