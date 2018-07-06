package 剑指Offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class 字符串的排列 {
	public ArrayList<String> Permutation(String str) {
		ArrayList<String> res = new ArrayList<>();
		if (str != null && str.length() > 0) {
			helper(str.toCharArray(), 0, res);
			Collections.sort(res);
		}
		return res;
	}

	public void helper(char[] cs, int i, List<String> list) {
		if (i == cs.length - 1) {
			String val = String.valueOf(cs);
			if (!list.contains(val))
				list.add(val);
		} else {
			for (int j = i; j < cs.length; j++) {
				swap(cs, i, j);
				helper(cs, i + 1, list);
				swap(cs, i, j);
			}
		}
	}

	public void swap(char[] cs, int i, int j) {
		char temp = cs[i];
		cs[i] = cs[j];
		cs[j] = temp;
	}
}