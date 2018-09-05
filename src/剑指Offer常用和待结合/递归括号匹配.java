package 剑指Offer常用和待结合;

import java.util.ArrayList;
import java.util.List;

public class 递归括号匹配 {
	public List<String> generateParenthesis(int n) {
		List<String> res  = new ArrayList<String>();
		helper(res, "", n, n);
		return res;
	}

	private void helper(List<String> res, String s, int left, int right) {
		if (left == 0 && right == 0) {
			res.add(s);
			return;
		}
		if (left > 0)
			helper(res, s + "(", left - 1, right);
		if (right > 0 && left < right)
			helper(res, s + ")", left, right - 1);
	}
}
