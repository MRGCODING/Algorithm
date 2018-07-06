package 剑指Offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class 回溯法迷宫问题BFS {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int m = sc.nextInt();
			int n = sc.nextInt();
			int[][] map = new int[m][n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			int[][] dir = { { 1, 0 }, { 0, 1 } };
			int[][] visited = new int[m][n];
			Node start = new Node(0, 0);
			Node end = new Node(m - 1, n - 1);
			Queue<Node> queue = new LinkedList<Node>();
			ArrayList<Node> arrayList = new ArrayList<Node>();// 用来保存每一个出队列的节点
			queue.offer(start);
			while (!queue.isEmpty()) {
				Node local = queue.remove();
				arrayList.add(local);
				for (int i = 0; i < 2; i++) {
					Node nbr = new Node(local.x + dir[i][0], local.y + dir[i][1]);
					if (nbr.x >= 0 && nbr.x < m && nbr.y >= 0 && nbr.y < n && map[nbr.x][nbr.y] == 0
							&& visited[nbr.x][nbr.y] == 0) {
						visited[nbr.x][nbr.y] = 1;
						queue.offer(nbr);
						nbr.prex = local.x;// 保存前驱节点
						nbr.prey = local.y;// 保存前驱节点
					}
				}
			}
			Stack<Integer> stack = new Stack<Integer>();
			int px = arrayList.get(arrayList.size() - 1).prex;// 获得目的节点的前驱节点
			int py = arrayList.get(arrayList.size() - 1).prey;
			stack.push(arrayList.size() - 1);// 将目的节点在arrayList中的位置记录下来，便于输出
			while (true) {
				if (px == 0 && py == 0) {// 找到起始节点就停止
					break;
				}
				for (int i = 0; i < arrayList.size(); i++) {// 循环找出每一个节点的前驱，找到就跳出当前循环
					if (arrayList.get(i).x == px && arrayList.get(i).y == py) {
						px = arrayList.get(i).prex;
						py = arrayList.get(i).prey;
						stack.push(i);// 保存节点在arrayList中的位置
						break;
					}
				}
			}
			System.out.println("(0,0)");
			while (!stack.isEmpty()) {
				System.out.println("(" + arrayList.get(stack.peek()).x + "," + arrayList.get(stack.peek()).y + ")");
				stack.pop();
			}

		}
	}
}

class Node {
	int x;
	int y;
	int prex;// 保存前驱节点位置
	int prey;

	Node(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
