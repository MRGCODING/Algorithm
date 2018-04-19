package niuke2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class 洗牌 {
	private static Scanner sc;

	static void mergeSorts(List<Integer> list1, List<Integer> list2, List<Integer> list3) {
		list1.clear();
		list2.clear();
		Stack<Integer> s1 = new Stack<>();
		Stack<Integer> s2 = new Stack<>();
		for (int i = 0; i < list3.size() / 2; i++)
			s1.push((Integer) list3.get(i));
		for (int i = list3.size() / 2; i < list3.size(); i++)
			s2.push((Integer) list3.get(i));
		list3.clear();
		while (!s1.empty()) {
			list3.add(s2.pop());
			list3.add(s1.pop());
		}
		Collections.reverse(list3);
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int num = sc.nextInt();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		while (num != 0) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			for (int j = 0; j < 2 * n; j++) {
				list3.add(sc.nextInt());
			}
			while (k != 0) {
				mergeSorts(list1, list2, list3);
				k--;
			}
			String str = list3.toString().replace("[", "").replace("]", "").replace(",", "");
			System.out.println(str);
			list3.clear();
			num--;
		}
	}
}
