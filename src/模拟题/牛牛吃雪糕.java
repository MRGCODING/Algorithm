package 模拟题;

import java.util.Scanner;

public class 牛牛吃雪糕 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		while (num-- != 0) {
			int n = sc.nextInt();
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			long sum = a + b * 2 + c * 3;
			if(sum / 6 >= n){
				System.out.println("Yes");
			}else{
				System.out.println("No");
			}
		}
	}
}
