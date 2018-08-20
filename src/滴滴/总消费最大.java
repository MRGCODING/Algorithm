package 滴滴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 总消费最大 {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String[] L1 = in.readLine().trim().split(" ");
		int n = Integer.parseInt(L1[0]);
		int m = Integer.parseInt(L1[1]);
		String[] L2 = in.readLine().trim().split(" ");
		int[] table = new int[n];
		for (int i = 0; i < n; i++) {
			table[i] = Integer.parseInt(L2[i]);
		}
		Arrays.sort(table);
		int[][] customer = new int[m][2];
		for (int i = 0; i < m; i++) {
			String[] L = in.readLine().trim().split(" ");
			customer[i][0] = Integer.parseInt(L[0]);
			customer[i][1] = Integer.parseInt(L[1]);
		}
		Arrays.sort(customer, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return b[1] - a[1];
			}
		});
		boolean[] tableFlag = new boolean[n];
		long res = 0L;
		for (int i = 0; i < m; i++) {
			if (customer[i][0] > table[n - 1])
				continue;
			int index = bs(table, customer[i][0]);
			while (index < n && tableFlag[index])
				index++;
			if (index < n) {
				res += customer[i][1];
				tableFlag[index] = true;
			}

		}
		System.out.println(res);
	}

	private static int bs(int[] num, int tar) {
		int low = 0;
		int high = num.length - 1;
		int mid = 0;
		while (low <= high) {
			mid = (high + low) >> 1;
			if (num[mid] >= tar)
				high = mid - 1;
			else
				low = mid + 1;
		}

		return low;
	}
}
