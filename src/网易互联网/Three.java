package 网易互联网;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Three {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int k = sc.nextInt();
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < n; i++)
			str.append('a');
		for (int j = 0; j < m; j++)
			str.append('z');
		ArrayList<String> res = new ArrayList<>();
		char[] charArray = str.toString().toCharArray();
		helper(charArray, 0, res);
		Collections.sort(res);
		if (res.get(k - 1) != null)
			System.out.println(res.get(k - 1));
		else
			System.out.println(-1);
	}

	private static void helper(char[] charArray, int i, ArrayList<String> res) {
		if (i == charArray.length - 1) {
			String str = String.valueOf(charArray);
			if (!res.contains(str))
				res.add(str);
		} else {
			for (int j = i; j < charArray.length; j++) {
				swap(charArray, i, j);
				helper(charArray, i + 1, res);
				swap(charArray, i, j);
			}
		}

	}

	private static void swap(char[] charArray, int i, int j) {
		char temp = charArray[i];
		charArray[i] = charArray[j];
		charArray[j] = temp;
	}
}
