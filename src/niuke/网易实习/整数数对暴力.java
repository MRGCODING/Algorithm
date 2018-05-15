package niuke.网易实习;

import java.util.Scanner;

/**
 * https://blog.csdn.net/anlian523/article/details/79763170
 * 
 * @author Lenovo
 *
 */
public class 整数数对暴力 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		if (k == 0) {
			System.out.println((long) n * n);
			return;
		}
		long count = 0;
		// for (int i = 0; i <= n; i++) {
		// for (int j = 1; j <= n; j++) {
		// if (i % j >= k)
		// count++;
		// }
		// }
		// 暴力会超时，数学方法处理lalala
		for (int i = k + 1; i <= n; i++) {
			count += (n / i) * (i - k);
			if (n % i >= k)
				count += n % i - k + 1;
		}
		System.out.println(count);
	}
}
