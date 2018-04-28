package niuke2017;

import java.util.Scanner;

/**
 * 回溯
 * 
 * @author Lenovo
 *
 */
public class 不要二{
	public static void main(String[] args) {
		int cnt = 0;
		Scanner sc = new Scanner(System.in);
		int w = sc.nextInt();
		int h = sc.nextInt();
		if (w % 4 == 0 || h % 4 == 0)
			cnt = w * h / 2;
		else
			cnt = w * h / 2 + 1;

		System.out.println(cnt);
	}
}