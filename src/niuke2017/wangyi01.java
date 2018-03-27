package niuke2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class wangyi01 {
	private static Scanner sc;

	static int com(int n, int k, int d, int[] a) {
		if (n < k || n <= 0 || k <= 0) {
			System.out.println("n,k数据输入不合理");
			return 0;
		}
		int[] b = new int[k + 1];
		int[] fg = new int[k + 1];
		for (int i = 1; i <= k; i++) {
			b[i] = i;
			fg[i] = i - k + n;
		}
		List<List<Integer>> comList = new ArrayList<>();
		while (true) {
			List<Integer> comp = new ArrayList<Integer>();
			for (int i = 1; i <= k; i++)
				comp.add(b[i]);
			comList.add(comp);
			if (b[1] == n - k + 1)
				break;
			for (int i = k; i >= 1; i--) {
				if (b[i] < fg[i]) {
					b[i]++;
					for (int j = i + 1; j <= k; j++)
						b[j] = b[j - 1] + 1;
					break;
				}
			}
		}
		for (int i = 0; i < comList.size(); i++) {
			List<Integer> cc = comList.get(i);
			for (int j = 1; j < cc.size(); j++) {
				if (cc.get(j) - cc.get(j - 1) > d) {
					comList.remove(i);
					i = i - 1;
					break;
				}
			}
		}
		// System.out.println(comList);
		int max = 0;
		for (int i = 0; i < comList.size(); i++) {
			int j = 0;
			int product = 1;
			while (j < k) {
				product = product * a[comList.get(i).get(j) - 1];
				j++;
			}
			if (product > max) {
				max = product;
			}
		}
		return max;
	}

	public static void main(String[] args) {
//		int n = 5;
//		int k = 3;
//		int d = 3;
//		int[] a = { 1, 2, 3, 4, 5 };

		int n,k,d;
		int[] a = null;
		sc = new Scanner(System.in);
		n = sc.nextInt();
		for(int i = 0;i < n;i++)
			a[i] = sc.nextInt();
		k = sc.nextInt();
		d = sc.nextInt();
		int max = com(n, k, d, a);
		System.out.println(max);
	}
}
