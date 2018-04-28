package niuke2017;

import java.util.Scanner;

public class 网易星际穿越 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Long h = sc.nextLong();
		for (long i = (long)Math.sqrt(h); ;i--) {
			if(i * i + i <= h){
				System.out.println(i);
				return;
			}
		}
	}
}
