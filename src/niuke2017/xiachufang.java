package niuke2017;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class xiachufang {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<String> set = new HashSet<>();
		while(sc.hasNext()){
			String str = sc.nextLine();
			String[] split = str.split(" ");
			for (String string : split) {
				set.add(string);
			}
		}
		System.out.println(set.size());
	}
}
