package 剑指Offer;

import java.util.HashMap;

public class 第一个只出现一次的字符 {
	public int FirstNotRepeatingChar(String str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < str.length(); i++) {
			if (map.containsKey(str.charAt(i))) {
				map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
			} else {
				map.put(str.charAt(i), 1);
			}
		}
		for(int i = 0;i < str.length();i++)
			if(map.get(str.charAt(i)) == 1)
				return str.indexOf(i);
		return -1;
	}
}