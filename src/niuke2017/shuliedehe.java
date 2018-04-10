package niuke2017;

import java.text.DecimalFormat;
import java.util.Scanner;

public class shuliedehe {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			double n = sc.nextInt();
			int m = sc.nextInt();
			double res = n;
			for (int i = 1; i < m; i++) {
				res += Math.sqrt(n);
				n = Math.sqrt(n);
			}
			DecimalFormat df = new DecimalFormat("#.00");
			System.out.println(df.format(res));
		}
	}
}
