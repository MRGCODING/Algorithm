package 剑指Offer;

import java.util.ArrayList;
import java.util.Comparator;

public class 排序数组为最小顺序 {
	public String PrintMinNumber(int[] numbers) {
		String res = "";
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < numbers.length; i++) {
			list.add(numbers[i]);
		}
		list.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				String str1 = o1 + "" + o2;
				String str2 = o2 + "" + o1;
				return str1.compareTo(str2);
			}
		});
		for (Integer i : list)
			res += i;
		return res;
	}
}
