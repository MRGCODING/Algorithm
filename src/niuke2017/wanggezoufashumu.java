package niuke2017;

import java.util.Scanner;

public class wanggezoufashumu {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			int row = sc.nextInt();
			int col = sc.nextInt();
			int[][] num = new int[row + 1][col + 1];
			for (int i = 0; i <= row; i++)
				for (int j = 0; j <= col; j++) {
					num[i][0] = num[0][j] = 1;
				}
			for (int i = 1; i <= row; i++) {
				for (int j = 1; j <= col; j++) {
					num[i][j] = num[i - 1][j] + num[i][j - 1];
				}
			}
			System.out.println(num[row][col]);
		}
	}
}
