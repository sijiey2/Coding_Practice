// DFS (Recursion)
// 20ms (17ms)

public class Solution {
	int[][] dirs = {{-1, 0},{1, 0},{0, -1},{0, 1}};

	public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image[sr][sc] == newColor) {
			return image;
		}

		explore(image, sr, sc, image[sr][sc], newColor);
		return image;
	}

	public void explore(int[][] image, int x, int y, int color, int newColor) {
		if (x < 0 || x >= image.length ||
			y < 0 || y >= image[0].length ||
			image[x][y] != color) {
			return;
		}

		image[x][y] = newColor;
		for (int i = 0; i < 4; i++) {
			explore(image, x + dirs[i][0], y + dirs[i][1], color, newColor);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[][] image = {{1,1,1},{1,1,0},{1,0,1}};
		sol.floodFill(image, 1,1,2);
	}
}
