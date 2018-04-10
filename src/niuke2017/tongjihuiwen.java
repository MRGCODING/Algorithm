package niuke2017;

import java.util.Scanner;

public class tongjihuiwen {
	static boolean isReward(String str) {
		if (new StringBuilder().append(str).reverse().toString().equals(str))
			return true;
		return false;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		while (sc.hasNext()) {
			String str1 = sc.nextLine();
			String str2 = sc.nextLine();

			for (int i = 0; i <= str1.length(); i++) {
				String str = new StringBuilder().append(str1).insert(i, str2).toString();
				if (isReward(str))
					count++;
			}
			System.out.println(count);
		}
	}
}
