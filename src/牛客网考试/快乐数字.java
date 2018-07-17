package 牛客网考试;

import java.util.HashSet;
import java.util.Set;

/**
 * 19 就是一个快乐数。
 * 
 * 1^2 + 9^2 = 82 8^2 + 2^2 = 68 6^2 + 8^2 = 100 1^2 + 0^2 + 0^2 = 1
 * 
 * @author Lenovo
 *
 */
public class 快乐数字 {
	/**
	 * 判断一个数字是否为快乐数字
	 * 
	 * @param number
	 * @return
	 */
	public boolean isHappy(int number) {
		Set<Integer> set = new HashSet<>(30);
		while (number != 1) {
			int sum = 0;
			while (number > 0) {
				// 计算当前值的每位数的平方 相加的和 在放入set中，如果存在相同的就认为不是 happy数字
				sum += (number % 10) * (number % 10);
				number = number / 10;
			}
			if (set.contains(sum)) {
				return false;
			} else {
				set.add(sum);
			}
			number = sum;
		}
		return true;
	}

	public static void main(String[] args) {
		int num = 345;
		int i = num % 10;
		int i1 = num / 10;
		int i2 = i1 / 10;
		System.out.println(i);
		System.out.println(i1);
		System.out.println(i2);
	}
}
