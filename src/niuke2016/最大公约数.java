package niuke2016;

import java.util.Scanner;

public class 最大公约数 {
	static int maxCount(int a, int b) {
		int temp;
		if (a < b) {
			temp = a;
			a = b;
			b = temp;

		}
		while (a % b != 0) {
			temp = a % b;
			a = b;
			b = temp;
		}
		return b;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int num = sc.nextInt();
			int n = sc.nextInt();
			int[] nums = new int[num];
			for (int i = 0; i < num; i++)
				nums[i] = sc.nextInt();
			for (int i = 0; i < num; i++) {
				if (nums[i] <= n)
					n += nums[i];
				else{
					int temp1 = n;
					n += maxCount(nums[i], temp1);
				}
					
			}
			System.out.println(n);
		}
	}
}
