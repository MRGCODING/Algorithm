package Offer;

public class 位运算 {
	public static int NumberOf1(int n) {
		int count = 0;
		String str = Integer.toBinaryString(n);
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '1') {
				count++;
			}
		}
		return count;
	}
}
