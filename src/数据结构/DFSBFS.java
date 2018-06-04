package 数据结构;

import java.util.LinkedList;
import java.util.Queue;

public class DFSBFS<T> {

	private int[][] racs; // 邻接矩阵
	private T[] verticeInfo; // 各个点所携带的信息.

	private int verticeNum; // 节点的数目,
	private int[] visitedCount; // 记录访问

	public DFSBFS(int[][] racs, T[] verticeInfo) {
		if (racs.length != racs[0].length) {
			throw new IllegalArgumentException("racs is not a adjacency matrix!");
		}
		if (racs.length != verticeInfo.length) {
			throw new IllegalArgumentException("Argument of 2 verticeInfo's length is error!");
		}
		this.racs = racs;
		this.verticeInfo = verticeInfo;
		verticeNum = racs.length;
		visitedCount = new int[verticeNum];
	}

	/**
	 * 深度遍历的递归
	 * 
	 * @param begin
	 *            从第几个节点开始遍历
	 */
	public void DFS(int begin, Queue<T> edges) {
		visitedCount[begin] = 1; // 标记begin为已访问
		edges.offer(verticeInfo[begin]); // 加入记录队列
		for (int a = 0; a < verticeNum; a++) { // 遍历相邻的点
			if ((racs[begin][a] != Integer.MAX_VALUE) && visitedCount[a] == 0) { // 相邻的点未被访问过
				DFS(a, edges);
			}
		}
	}

	/**
	 * 开始深度优先遍历
	 * 
	 * @return 返回保持有遍历之后的顺序的队列
	 */
	public Queue<T> depthFirstSearch() {
		initVisitedCount(); // 将记录访问次序的数组初始化为0
		Queue<T> edges = new LinkedList<>(); // 用于存储遍历过的点,用于输出
		int begin = -1;
		while ((begin = findNotVisited()) != -1) { // 不等于-1说明还有未访问过的点
			DFS(begin, edges);
		}
		return edges;
	}

	/**
	 * 广度优先遍历
	 * 
	 * @return 返回保持有遍历之后的顺序的队列
	 */
	public Queue<T> breadthFirstSearch() {
		initVisitedCount(); // 将记录访问次序的数组初始化为0
		Queue<Integer> tallyQueue = new LinkedList<>(); // 初始化队列
		Queue<T> edges = new LinkedList<>(); // 用于存储遍历过的点,用于输出
		int nowVertice = -1; // 当前所在的点
		while ((nowVertice = findNotVisited()) != -1) { // 寻找还未被访过问的点
			visitedCount[nowVertice] = 1; // 设置访问标记
			edges.offer(verticeInfo[nowVertice]);
			tallyQueue.offer(nowVertice); // 将当前孤立部分一个顶点加入记录队列中
			while (!tallyQueue.isEmpty()) { // 只要队列不为空
				nowVertice = tallyQueue.poll(); // 取出队首的节点
				for (int a = 0; a < verticeNum; a++) { // 遍历所有和nowVertice相邻的节点
					if ((racs[nowVertice][a] != Integer.MAX_VALUE) && visitedCount[a] == 0) { // 没有访问过
						visitedCount[a] = 1; // 记为标记过
						tallyQueue.offer(a); // 加入队列,上面会继续取出.来遍历
						edges.offer(verticeInfo[a]); // 记录
					}
				}
			}
		}
		return edges;
	}

	/**
	 * 寻找没有被访问过的顶点.
	 * 
	 * @return > 0 即为还未被访问过的顶点. -1 说明所有的节点都被访问过了.
	 */
	private int findNotVisited() {
		for (int i = 0; i < verticeNum; i++) {
			if (visitedCount[i] == 0) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 将记录访问的数组初始化为0
	 */
	private void initVisitedCount() {
		for (int i = 0; i < visitedCount.length; i++) {
			visitedCount[i] = 0;
		}
	}

	public static void main(String[] args) {

		int[][] racs = new int[][] { { 0, 1, 0, 1, 0, }, { 1, 0, 1, 0, 1, }, { 0, 1, 0, 1, 1, }, { 1, 0, 1, 0, 0, },
				{ 0, 1, 1, 0, 0, }, };
		int oo = Integer.MAX_VALUE;
		int[][] racs1 = new int[][] { { oo, 1, 1, oo, oo, oo, oo, oo }, { 1, oo, oo, 1, oo, oo, oo, oo },
				{ 1, oo, oo, 1, 1, oo, oo, oo }, { oo, 1, 1, oo, oo, 1, 1, oo }, { oo, oo, 1, oo, oo, oo, oo, 1 },
				{ oo, oo, oo, 1, oo, oo, 1, oo }, { oo, oo, oo, 1, oo, 1, oo, oo },
				{ oo, oo, oo, oo, 1, oo, oo, oo }, };

		String[] verticeInfos1 = new String[] { "V0", "V1", "V2", "V3", "V4", "V5", "V6", "V7" };
		// Graph<String> graph = new Graph<>(racs2, verticeInfos2);
		// Queue<String> dr = graph.depthFirstSearch();
		// Queue<String> br = graph.breadthFirstSearch();
		//
		// System.out.println("--遍历");
		// System.out.println("----深度优先结果: " + dr);
		// System.out.println("----广度优先结果: " + br);
	}
}
