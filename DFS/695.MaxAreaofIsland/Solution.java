// DFS -R
// 43ms (okay) -31ms

public class Solution {
	int max = 0;
	int[][] dirs = {{-1, 0},{1, 0},{0,-1},{0,1}};

	public int maxAreaOfIsland(int[][] grid) {
		if (grid == null || grid.length == 0) {
			return 0;
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {
					int temp = explore(grid, i, j);
					max = Math.max(temp, max);
				}
			}
		}
		return max;
	}

	public int explore(int[][] grid, int x, int y) {
		if (x < 0 || x >= grid.length ||
			y < 0 || y >= grid[0].length ||
			grid[x][y] == 0) {
			return 0;
		}

		grid[x][y] = 0;
		int result = 1;
		for (int i = 0; i < 4; i++) {
			result += explore(grid, x + dirs[i][0], y + dirs[i][1]);
		}
		return result;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] grid = {{0,0,1,0,0,0,0,1,0,0,0,0,0},
						{0,0,0,0,0,0,0,1,1,1,0,0,0},
						{0,1,1,0,1,0,0,0,0,0,0,0,0},
						{0,1,0,0,1,1,0,0,1,0,1,0,0},
						{0,1,0,0,1,1,0,0,1,1,1,0,0},
						{0,0,0,0,0,0,0,0,0,0,1,0,0}};
		System.out.println(sol.maxAreaOfIsland(grid));
	}
}
