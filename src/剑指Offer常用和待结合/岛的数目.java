package 剑指Offer常用和待结合;

/**
 * LC200 https://blog.csdn.net/DERRANTCM/article/details/47970795
 * 
 * @author Lenovo
 *
 */
public class 岛的数目 {
	public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
			return 0;
		int res = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == '1') {
					res++;
					helper(grid, i, j);
				}
			}
		}
		return res;
	}

	private void helper(char[][] grid, int i, int j) {
		if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != '1')
			return;
        grid[i][j] = '0';
		helper(grid, i, j - 1);
		helper(grid, i, j + 1);
		helper(grid, i - 1, j);
		helper(grid, i + 1, j);
	}
}