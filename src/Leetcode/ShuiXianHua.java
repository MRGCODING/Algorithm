package Leetcode;

public class ShuiXianHua {
	public static void main(String[] args) {
		// 百位数字
		int hundreds = 0;
		// 十位数字
		int tens = 0;
		// 个位数字
		int ones = 0;
		// 统计水仙花数的个数
		int dataCount = 0;
		for (int i = 100; i < 1000; i++) {
			// 获取百位数字
			hundreds = i / 100;
			// 获取十位数字
			tens = i / 10 % 10;
			// 获取个位数字
			ones = i % 10;
			// 根据水仙花数的条件进行判断
			if (i == (hundreds * hundreds * hundreds + tens * tens * tens + ones * ones * ones)) {
				// 统计个数
				dataCount++;
				// 打印出水仙花数
				System.out.println(dataCount + "****水仙花数----" + i);
			}
		}
	}
}
