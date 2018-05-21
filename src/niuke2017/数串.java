package niuke2017;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class 数串 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<Integer> nums = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			nums.add(sc.nextInt());
		}
		Collections.sort(nums, new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String s1 = String.valueOf(o1);
				String s2 = String.valueOf(o2);
				return (s2 + s1).compareTo(s1 + s2);
			}
		});	
		for (int i = 0; i < n; i++)
			System.out.print(nums.get(i));
	}
}
