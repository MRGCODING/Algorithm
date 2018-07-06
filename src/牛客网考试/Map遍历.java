package 牛客网考试;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Map遍历 {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(3, "c");
		map.put(2, "b");
		map.put(1, "a");
		Set<Integer> set = map.keySet();
		Iterator<Integer> in = set.iterator();
		while (in.hasNext()) {
			Integer key = in.next();
			System.out.println(key + "->" + map.get(key));
		}

		Set<Entry<Integer, String>> setkey = map.entrySet();
		Iterator<Entry<Integer, String>> ins = setkey.iterator();
		while (ins.hasNext()) {
			Entry<Integer, String> me = ins.next();
			System.out.println(me.getKey() + "->" + me.getValue());
		}
	}
}
