package niuke2017;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * BFS 对于已经被访问的节点，用set记录，这样为被访问的节点才不会特别长
 * 
 * @author Lenovo
 *
 */
public class 大数之神秘的小易BFS {
	private static Scanner scanner;

	public static void main(String[] args) {
		scanner = new Scanner(System.in);
		while (scanner.hasNextLong()) {

			Long x = scanner.nextLong();
			Map<Long, Integer> map = new HashMap<Long, Integer>();
			Queue<Long> queue = new LinkedList<Long>();
			queue.add(x);
			map.put(x, 0);
			while (!queue.isEmpty()) {
				Long n = queue.poll();
				if (n == 0) {
					System.out.println(map.get(n));
					return;
				}
				if (map.get(n) > 100000)
					break;
				Long key1 = (n * 4 + 3) % 1000000007;
				Long key2 = (n * 8 + 7) % 1000000007;
				if (!map.containsKey(key1)) {
					map.put(key1, map.get(n) + 1);
					queue.add(key1);
				}
				if (!map.containsKey(key2)) {
					map.put(key2, map.get(n) + 1);
					queue.add(key2);
				}
			}
			System.out.println(-1);
		}
	}
}
