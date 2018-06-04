package 数据结构;

import java.util.LinkedList;
import java.util.List;

public class Graph<T> {
	private int[][] racs; // 邻接矩阵
	private T[] verticeInfo; // 各个点所携带的信息.

	private int verticeNum; // 顶点的数目,
	private int[] currDist; // 最短路径算法中用来记录每个顶点距离起始顶点路径的长度.

	public Graph(int[][] racs, T[] verticeInfo) {
		if (racs.length != racs[0].length) {
			throw new IllegalArgumentException("racs is not a adjacency matrix!");
		}
		if (racs.length != verticeInfo.length) {
			throw new IllegalArgumentException("Argument of 2 verticeInfo's length is error!");
		}
		this.racs = racs;
		this.verticeInfo = verticeInfo;
		verticeNum = racs.length;
	}

	/**
	 * 使用 Dijkstra算法寻找最短路径
	 * 
	 * @param first
	 *            路径开始的顶点
	 * @return 返回最后的最短路径
	 */
	public int[] dijkstraAlgorithm(int first) {
		if (first < 0 || first >= verticeNum) {
			throw new IndexOutOfBoundsException("should between 0 ~ " + (verticeNum - 1));
		}
		setNumberAsInfinitie();
		currDist[first] = 0;
		List<Integer> toBeChecked = new LinkedList<>();
		for (int i = 0; i < verticeNum; i++) {
			toBeChecked.add(i); 
		}
		while (!toBeChecked.isEmpty()) {
			int nowVertice = findMinCurrDistVerticeAndRemoveFormList(toBeChecked);
			for (int i = 0; i < verticeNum; i++) {
				int nextVertice = -1; // 邻接节点
				int weight = Integer.MAX_VALUE; // 到达邻接节点的权重
				if (racs[nowVertice][i] != Integer.MAX_VALUE) { // 得到邻接顶点
					if (toBeChecked.contains(i)) {
						nextVertice = i;
						weight = racs[nowVertice][i];
					}
				}
				if (nextVertice == -1) {
					continue;
				}
				if (currDist[nextVertice] > currDist[nowVertice] + weight) {
					currDist[nextVertice] = currDist[nowVertice] + weight;
				}
			}

		}
		for (int i = 0; i < currDist.length; i++) {
			System.out.println("现在顶点 " + verticeInfo[i].toString() + " 距离顶点 " + verticeInfo[first].toString()
					+ " 的最短距离为 " + currDist[i]);
		}
		return currDist;
	}

	/**
	 * 将currDist数组初始化为无穷大
	 */
	private void setNumberAsInfinitie() {
		currDist = new int[verticeNum];
		for (int i = 0; i < verticeNum; i++) {
			currDist[i] = Integer.MAX_VALUE;
		}
	}

	/**
	 * 寻找出当前距离起始顶点路径最短的顶点,并将其从toBeCheck中删除
	 * 
	 * @param list
	 * @return
	 */
	private int findMinCurrDistVerticeAndRemoveFormList(List<Integer> list) {
		int num = list.get(0);
		int dist = currDist[num];
		int listIndex = 0;
		for (int i = 1; i < list.size(); i++) {
			int index = list.get(i);
			if (currDist[index] < dist) {
				dist = currDist[index];
				num = index;
				listIndex = i;
			}
		}
		list.remove(listIndex);
		return num;
	}

	/**
	 * 使用Ford的方法寻找最短路径
	 * 
	 * @param first
	 *            路径开始的顶点
	 */
	public int[] fordAlgorithm(int first) {
		if (first < 0 || first >= verticeNum) {
			throw new IndexOutOfBoundsException("should between 0 ~ " + (verticeNum - 1));
		}
		setNumberAsInfinitie();
		currDist[first] = 0;
		while (true) {
			boolean hasLessEdge = false; // 是否有使currDist更小的边
			for (int s = 0; s < verticeNum; s++) {
				for (int e = 0; e < verticeNum; e++) {
					if (racs[s][e] != Integer.MAX_VALUE) {
						int weight = getWeightPreventOverflow(s, e);
						if (currDist[e] > currDist[s] + weight) {
							hasLessEdge = true;
							currDist[e] = currDist[s] + racs[s][e];
						}
					}
				}
			}
			if (!hasLessEdge) {
				break;
			}
		}
		for (int i = 0; i < currDist.length; i++) {
			System.out.println("现在顶点 " + verticeInfo[i].toString() + " 距离顶点 " + verticeInfo[first].toString()
					+ " 的最短距离为 " + currDist[i]);
		}

		return currDist;
	}

	/**
	 * 处理并获得权重,并且使得到的结果在进行路径长度的加减操作时不会出现溢出
	 * 
	 * @param start
	 * @param end
	 * @return
	 */
	private int getWeightPreventOverflow(int start, int end) {
		int weight = 0;
		// 防止加减法溢出
		if (currDist[start] == Integer.MAX_VALUE && racs[start][end] > 0) {
			weight = 0;
		} else if (currDist[start] == Integer.MIN_VALUE && racs[start][end] < 0) {
			weight = 0;
		} else {
			weight = racs[start][end];
		}
		return weight;
	}
}
