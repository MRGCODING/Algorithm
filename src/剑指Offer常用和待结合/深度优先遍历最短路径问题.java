package 剑指Offer常用和待结合;

public class 深度优先遍历最短路径问题 {
	public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
		int[][] graph = new int[n][n];
		for (int[] flight : flights)
			graph[flight[0]][flight[1]] = flight[2];
		boolean[] visited = new boolean[n];
		int[] minCost = { Integer.MAX_VALUE };
		helper(graph, visited, src, dst, K, minCost, 0);
		return minCost[0] == Integer.MAX_VALUE ? -1 : minCost[0];
	}

	private void helper(int[][] graph, boolean[] visited, int src, int dst, int k, int[] minCost, int cost) {
		if (src == dst) {
			minCost[0] = Math.min(cost, minCost[0]);
		}
		if (cost < minCost[0] && k >= 0) {
			for (int i = 0; i < visited.length; i++) {
				if (graph[src][i] != 0 && !visited[i]) {
					visited[i] = true;
					helper(graph, visited, i, dst, k - 1, minCost, cost + graph[src][i]);
					visited[i] = false;
				}
			}
		}
	}
}
