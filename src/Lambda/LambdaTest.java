package Lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaTest {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("a", "c", "b");
		// Collections.sort(list, new Comparator<String>() {
		// @Override
		// public int compare(String o1, String o2) {
		// return o1.compareTo(o2);
		// }
		// });
		Collections.sort(list, (Comparator<String>) (String s1, String s2) -> {
			return s1.compareTo(s2);
		});
		System.out.println(list);
	}
}
