package 剑指Offer常用和待结合;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 自定义数据结构 {
	// Cheapest Flights Within K Stops
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		int[][] graph = new int[n][n];
		for (int[] flight : flights) {
			graph[flight[0]][flight[1]] = flight[2];
		}

		int[] costs = new int[n];
		Arrays.fill(costs, Integer.MAX_VALUE);

		Set<Integer> set1 = new HashSet<>();
		set1.add(src);
		costs[src] = 0;
		int steps = 0;
		while (!set1.isEmpty()) {
			if (steps++ > K)
				break;
			Set<Integer> set2 = new HashSet<>();
			for (int from : set1) {
				for (int i = 0; i < n; ++i) {
					if (graph[from][i] > 0 && costs[from] + graph[from][i] < costs[i]) {
						costs[i] = costs[from] + graph[from][i];
						set2.add(i);
					}
				}
			}

			set1 = set2;
		}

		return costs[dst] == Integer.MAX_VALUE ? -1 : costs[dst];
	}
}
