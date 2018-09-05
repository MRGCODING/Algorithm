package 携程;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Two {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int t = sc.nextInt();
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			int num = sc.nextInt();
			int start = sc.nextInt();
			int end = sc.nextInt();
			if (t >= start && t <= end) {
				list.add(num);
			}
		}
		if (list.size() == 0) {
			System.out.println("null");
		}
		Collections.sort(list);
		for (Integer i : list)
			System.out.println(i);
	}
}
