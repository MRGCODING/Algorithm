package 剑指Offer;

import java.util.ArrayList;
import java.util.HashMap;

public class 字符流中第一个不重复的数字 {
	HashMap<Character, Integer> map = new HashMap<>();
	ArrayList<Character> list = new ArrayList<>();

	// Insert one char from stringstream
	public void Insert(char ch) {
		list.add(ch);
		if (map.containsKey(ch)) {
			map.put(ch, map.get(ch) + 1);
		} else {
			map.put(ch, 1);
		}
	}

	// return the first appearence once char in current stringstream
	public char FirstAppearingOnce() {
		char res = '#';
		for(char ch : list){
			if(map.get(ch) == 1){
				res = ch;
				break;
			}
		}
		return res;
	}
}
