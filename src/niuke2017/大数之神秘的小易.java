package niuke2017;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

/**
 * BFS,典型用法是使用队列
 * 
 * @author Lenovo
 *
 */
public class 大数之神秘的小易 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int x = sc.nextInt();

			Map<Long, Integer> map = new HashMap<Long, Integer>();

			Queue<Long> queue = new LinkedList<Long>();
			queue.offer((long) x);
			map.put((long) x, 0);
			while (!queue.isEmpty()) {
				long n = queue.poll();
				if (n == 0) {
					System.out.println(map.get(n));// 返回次数
					return;
				}
				if (map.get(n) >= 100001)// map中Integer存level迭代次数，超过100000即continue;
					continue;

				Long key1 = (4 * n + 3) % 1000000007;
				Long key2 = (8 * n + 7) % 1000000007;

				if (!map.containsKey(key1)) {
					map.put(key1, map.get(n) + 1);
					queue.offer(key1);
				}
				if (!map.containsKey(key2)) {
					map.put(key2, map.get(n) + 1);
					queue.offer(key2);
				}
			}
			System.out.println(-1);
		}
	}
}
