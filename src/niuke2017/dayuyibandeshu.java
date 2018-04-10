package niuke2017;

import java.util.Scanner;

public class dayuyibandeshu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.nextLine();
			String[] split = str.split(" ");
			int temp[] = new int[100];//初始为10错误，原因为java.lang.ArrayIndexOutOfBoundsException数组越界
			for (int i = 0; i < split.length; i++) {
				temp[Integer.parseInt(split[i])]++;
			}
			for (int i = 0; i < temp.length; i++) {
				if (temp[i] >= split.length / 2)
					System.out.println(i);
			}
		}
	}
}
