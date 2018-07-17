package 剑指Offer;

import java.util.ArrayList;
import java.util.List;

/**
 * 两个有序数组合并成一个，原数组包含重复
 * 
 * @author Lenovo
 *
 */
public class 数组合并 {
	public List<Integer> mergeList(int[] a, int[] b) {
		List<Integer> result = new ArrayList<Integer>();
		int i = 0, j = 0;
		while (i < a.length && j < b.length) {
			if (i != a.length - 1 && a[i] == a[i + 1]) {
				i++;
				continue;
			}
			if (j != b.length - 1 && b[j] == b[j + 1]) {
				j++;
				continue;
			}
			if (a[i] > b[j]) {
				result.add(b[j++]);
			} else if (a[i] < b[j]) {
				result.add(a[i++]);
			} else if (a[i] == b[j]) {
				result.add(a[i]);
				i++;
				j++;
			}
		}
		while (i < a.length) {
			result.add(a[i++]);
		}
		while (j < b.length) {
			result.add(b[j++]);
		}
		return result;
	}
}
