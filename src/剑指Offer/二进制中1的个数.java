package 剑指Offer;

public class 二进制中1的个数 {
	public int NumberOf1(int n) {
		int count = 0;
		int flag = 1;
		while (flag != 0) {
			if ((n & flag) != 0)
				count++;
			flag = flag << 1;
		}
		return count;
		// int count = 0;
		// String str = Integer.toBinaryString(n);
		//
		// for (int i = 0; i < str.length(); i++) {
		// if (str.charAt(i) == '1') {
		// count++;
		// }
		// }
		//
		// return count;
	}
}
