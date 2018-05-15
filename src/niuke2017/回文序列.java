package niuke2017;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class 回文序列 {
	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int nums = sc.nextInt();
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < nums; i++) {
			list.add(sc.nextInt());
		}
		System.out.println(getSum(list));
	}

	public static int getSum(List<Integer> list) {
		if (list.size() <= 1)
			return 0;
		int operation = 0;
		while (list.size() > 1) {
			if (list.get(0) > list.get(list.size() - 1)) {
				int a = list.get(list.size() - 2);
				int b = list.get(list.size() - 1);
				list.set(list.size() - 2, a + b);
				list.remove(list.size() - 1);
				operation++;
			} else if (list.get(0) < list.get(list.size() - 1)) {
				int a = list.get(0);
				int b = list.get(1);
				list.set(0, a + b);
				list.remove(1);
				operation++;
			} else {
				list.remove(0);
				list.remove(list.size() - 1);
			}
		}
		return operation;
	}
}