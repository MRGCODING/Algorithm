package niuke2017;

import java.util.Scanner;

public class 句子反转 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		String[] split = str.split(" ");
		for (int i = split.length - 1; i >= 0; i--) {
			if (i != 0)
				System.out.print(split[i] + " ");
			else
				System.out.print(split[i]);
		}
	}
}
