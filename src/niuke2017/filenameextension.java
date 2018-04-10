package niuke2017;

import java.util.Scanner;

public class filenameextension {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String str = sc.nextLine();
			int indexOf = str.lastIndexOf(".");
			if (indexOf != -1)
				System.out.println(str.substring(indexOf + 1));
			else
				System.out.println("null");
		}
	}
}
