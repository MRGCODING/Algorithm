package 字节跳动;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Two {
	private static Scanner sc;

	public static class Point {
		private int x;
		private int y;

		public int getX() {
			return x;
		}

		public void setX(int x) {
			this.x = x;
		}

		public int getY() {
			return y;
		}

		public void setY(int y) {
			this.y = y;
		}
	}

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int m = sc.nextInt();
		sc.nextLine();
		ArrayList<Point> list = new ArrayList<>();
		for (int i = 0; i < m; i++) {
			String[] str = sc.nextLine().split(";");
			for (int j = 0; j < str.length; j++) {
				String[] strr = str[j].split(",");
				Point p = new Point();
				p.setX(Integer.parseInt(strr[0]));
				p.setY(Integer.parseInt(strr[1]));
				list.add(p);
			}
		}
		Collections.sort(list, new Comparator<Point>() {
			@Override
			public int compare(Point o1, Point o2) {
				if (o1.getX() < o2.getX())
					return -1;
				else if (o1.getX() > o2.getX())
					return 1;
				else
					return 0;
			}
		});
		List<Point> res = new ArrayList<>();
		int x = list.get(0).getX();
		int y = list.get(0).getY();
		for (int i = 1; i < list.size(); i++) {
			if (list.get(i).getX() > y) {
				Point p = new Point();
				p.setX(x);
				p.setY(y);
				res.add(p);
				x = list.get(i).getX();
				y = list.get(i).getY();
				if (i == list.size() - 1) {
					Point pp = new Point();
					pp.setX(x);
					pp.setY(y);
					res.add(pp);
				}
			} else {
				y = list.get(i).getY();
			}
		}
		for (int i = 0; i < res.size() - 1; i++) {
			System.out.print(res.get(i).getX() + "," + res.get(i).getY() + ";");
		}
		System.out.println(res.get(res.size() - 1).getX() + "," + res.get(res.size() - 1).getY());
		sc.close();
	}
}