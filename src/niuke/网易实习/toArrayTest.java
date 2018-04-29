package niuke.网易实习;

import java.util.ArrayList;
import java.util.List;

public class toArrayTest {
	public static void main(String[] args) {
		List<String> list = new ArrayList<>();
		list.add("1");
		String[] array = list.toArray(new String[] {});
		System.out.println(array[0]);
	}
}
