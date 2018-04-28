package heima;

public class 完数 {
	public static void main(String[] args) {
		for (int i = 2; i < 1000; i++) {
			int s = 0;
			for (int j = 1; j < i; j++) {
				if (i % j == 0)
					s += i;
			}
			if (s == i) {
				System.out.print(i + ":");
				for (int k = 1; k < i; k++) {
					if (i % k == 0) {
						System.out.print(k);
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
	}
}
