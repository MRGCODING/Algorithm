package 模拟题;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[] matrix = new char[n * n];
		ArrayList<String> map = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			map.add(sc.nextLine());
			char[] clone = map.get(i).toCharArray().clone();
			System.out.println(clone.length);
			System.out.println(clone[0]);
//			for (int j = 0; j < n; j++) {
//				matrix[i * j + i] = charArray[i];
//			}
		}
	}
}
