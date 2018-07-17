package 剑指Offer;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.Test;

/**
 * LRU的缓存结构和LinkedHashMap十分相似，所以完全可以借助LinkedHashMap实现
 * 
 * 要求：
 * 实现一个 LRU 缓存，当缓存数据达到 N之后需要淘汰掉最近最少使用的数据。 N小时之内没有被访问的数据也需要淘汰掉。
 * 
 * 
 * @author Lenovo
 *
 */
public class LRU {
	class LRULinkedMap<K, V> {
		@SuppressWarnings("unused")
		private int cacheSize;// 最大缓存大小
		private LinkedHashMap<K, V> cacheMap;

		@SuppressWarnings({ "rawtypes", "serial", "unchecked" })
		public LRULinkedMap(int cacheSize) {
			this.cacheSize = cacheSize;
			cacheMap = new LinkedHashMap(16, 0.75F, true) {
				@Override
				protected boolean removeEldestEntry(Map.Entry eldest) {
					// 它默认是返回 false，也就是不会管有没有超过阈值。
					// 所以我们定义大于了阈值时返回 true，这样 LinkedHashMap 就会帮我们删除最近最少使用的数据。
					if (cacheSize + 1 == cacheMap.size()) {
						return true;
					} else {
						return false;
					}
				}
			};
		}

		public void put(K key, V value) {
			cacheMap.put(key, value);
		}

		public V get(K key) {
			return cacheMap.get(key);
		}

		public Collection<Map.Entry<K, V>> getAll() {
			return new ArrayList<Map.Entry<K, V>>(cacheMap.entrySet());
		}
	}

	@Test
	public void put() throws Exception {
		LRULinkedMap<String, Integer> map = new LRULinkedMap(3);
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 3);
		for (Map.Entry<String, Integer> e : map.getAll()) {
			System.out.print(e.getKey() + " : " + e.getValue() + "\t");
		}
		System.out.println("");
		map.put("4", 4);
		for (Map.Entry<String, Integer> e : map.getAll()) {
			System.out.print(e.getKey() + " : " + e.getValue() + "\t");
		}
	}

	@Test
	public void get() throws Exception {
		LRULinkedMap<String, Integer> map = new LRULinkedMap(4);
		map.put("1", 1);
		map.put("2", 2);
		map.put("3", 3);
		map.put("4", 4);
		for (Map.Entry<String, Integer> e : map.getAll()) {
			System.out.print(e.getKey() + " : " + e.getValue() + "\t");
		}
		System.out.println("");
		map.get("1");
		for (Map.Entry<String, Integer> e : map.getAll()) {
			System.out.print(e.getKey() + " : " + e.getValue() + "\t");
		}
	}
}
