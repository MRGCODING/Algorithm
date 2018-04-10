package niuke2017;

import java.util.Scanner;

public class maipingguotanxin {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int num = sc.nextInt();
			int res = 0;
			if (num % 8 == 0) {
				res += num / 8;
				System.out.println(res);
				return;
			} else {
				res += num / 8;
				num %= 8;
				while(res >= 0){
					if (num % 6 == 0) {
						res += num / 6;
						System.out.println(res);
						return;
					} else {
						res--;
						num += 8;
					}
				}
			}
			System.out.println("-1");
		}
	}
}
