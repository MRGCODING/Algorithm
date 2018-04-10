package test;

public class T {
	public static void main(String[] args) {
		String str = "AB";
		String pattern = ".*(.)(\\1).*";
		boolean test = str.matches(pattern);
		System.out.println(test);
	}
}
