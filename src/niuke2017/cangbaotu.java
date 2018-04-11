package niuke2017;

import java.util.Scanner;

public class cangbaotu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str1 = sc.nextLine();
			String str2 = sc.nextLine();
			int count = 0;
			String res = "Yes";
			for (int i = 0; i < str2.length(); i++) {
				if(str1.indexOf(str2.charAt(i)) != -1){
					str1 = str1.substring(str1.indexOf(str2.charAt(i))+1);
					continue;
				}
				res = "No";
			}
			System.out.println(res);
		}
	}
}
