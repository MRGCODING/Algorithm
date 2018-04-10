package niuke2017;

import java.util.Scanner;
/**
 *  1.单词每个字母都是大写字母
	2.单词没有连续相等的字母
	3.单词没有形如“xyxy”(这里的x，y指的都是字母，并且可以相同)这样的子序列，子序列可能不连续。
 * @author Lenovo
 *
 */
public class xiaoyixihuandedanci {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String word = sc.next();
			if (isAllUpCase(word) && isConEql(word) && isThrEql(word))
				System.out.println("Likes");
			else
				System.out.println("Dislikes");
		}
	}

	public static boolean isAllUpCase(String word) {
		return word.matches("[A-Z]+");
	}

	public static boolean isConEql(String word) {
		return !word.matches(".*(.)(\\1).*");
	}

	public static boolean isThrEql(String word) {
		return !word.matches(".*(.).*(.)(.*\\1)(.*\\2).*");
	}
}
