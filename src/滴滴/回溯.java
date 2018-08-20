package 滴滴;

import java.util.*;

public class 回溯 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int m = in.nextInt();
			int p = in.nextInt();
			int[][] map = new int[n][m];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					map[i][j] = in.nextInt();
				}
			}
			ArrayList<ArrayList<int[]>> res = new ArrayList<>();
			ArrayList<int[]> path = new ArrayList<>();
			int[] start = { 0, 0 };
			map[0][0] = 0;
			path.add(start);
			findPath(res, path, map, p, n, m);
			if (res.size() <= 0) {
				System.out.println("Can not escape!");
			} else {
				ArrayList<int[]> min = res.get(0);
				for (int i = 1; i < res.size(); i++) {
					if (res.get(i).size() < min.size()) {
						min = res.get(i);
					}
				}
				System.out.print("[" + min.get(0)[0] + "," + min.get(0)[1] + "]");
				for (int i = 1; i < min.size(); i++) {
					System.out.print(",[" + min.get(i)[0] + "," + min.get(i)[1] + "]");
				}
				System.out.println();
			}

		}
	}

	public static void findPath(ArrayList<ArrayList<int[]>> res, ArrayList<int[]> path, int[][] map, int p, int n,
			int m) {
		int[] cur = new int[2];
		cur[0] = path.get(path.size() - 1)[0];
		cur[1] = path.get(path.size() - 1)[1];
		if (p < 0) {
			return;
		}
		if (p >= 0 && cur[0] == 0 && cur[1] == m - 1) {
			res.add(new ArrayList<>(path));
			return;
		}
		if (cur[0] - 1 >= 0) {
			int[] temp = new int[2];
			temp[0] = cur[0] - 1;
			temp[1] = cur[1];
			if (map[temp[0]][temp[1]] == 1) {
				map[temp[0]][temp[1]] = 0;
				path.add(temp);
				findPath(res, path, map, p - 3, n, m);
				path.remove(path.size() - 1);
				map[temp[0]][temp[1]] = 1;
			}
		}
		if (cur[1] + 1 < m) {
			int[] temp = new int[2];
			temp[0] = cur[0];
			temp[1] = cur[1] + 1;
			if (map[temp[0]][temp[1]] == 1) {
				map[temp[0]][temp[1]] = 0;
				path.add(temp);
				findPath(res, path, map, p - 1, n, m);
				path.remove(path.size() - 1);
				map[temp[0]][temp[1]] = 1;
			}
		}
		if (cur[0] + 1 < n) {
			int[] temp = new int[2];
			temp[0] = cur[0] + 1;
			temp[1] = cur[1];
			if (map[temp[0]][temp[1]] == 1) {
				map[temp[0]][temp[1]] = 0;
				path.add(temp);
				findPath(res, path, map, p, n, m);
				path.remove(path.size() - 1);
				map[temp[0]][temp[1]] = 1;
			}
		}
		if (cur[1] - 1 >= 0) {
			int[] temp = new int[2];
			temp[0] = cur[0];
			temp[1] = cur[1] - 1;
			if (map[temp[0]][temp[1]] == 1) {
				map[temp[0]][temp[1]] = 0;
				path.add(temp);
				findPath(res, path, map, p - 1, n, m);
				path.remove(path.size() - 1);
				map[temp[0]][temp[1]] = 1;
			}
		}
	}
}
