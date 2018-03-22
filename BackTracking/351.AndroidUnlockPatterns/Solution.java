// DFS (Recursion, D&C)
// Key words: Count the total number of unlock patterns
// Idea: for each num, try next num (1 ~ 9)
//       check visited: int[][] skip
// 10ms (0ms) 

public class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[9][1] = skip[2][8] = 
        skip[8][2] = skip[3][7] = skip[7][3] = 
        skip[4][6] = skip[6][4] = 5;
        boolean vis[] = new boolean[10];
        int result = 0;

        // total # of keys (n ~ m)
        for (int i = m; i <= n; i++) {
            // starting point (3 situations)
            result += dfs(vis, skip, 1, i-1) * 4; // 1,3,7,9
            result += dfs(vis, skip, 2, i-1) * 4; // 2,4,6,8
            result += dfs(vis, skip, 5, i-1); // 5
        }

        return result;
    }

    public int dfs(boolean vis[], int[][] skip, int cur, int remain) {
        if (remain < 0) return 0;
        if (remain == 0) return 1;
        int result = 0;
        vis[cur] = true;

        // next point (1 ~ 9)
        for (int i = 1; i <= 9; i++) {
            if (!vis[i] && (skip[cur][i] == 0 || (vis[skip[cur][i]]))) {
                result += dfs(vis, skip, i, remain-1);
            }
        }
        vis[cur] = false;
        return result;   
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numberOfPatterns(1,1));
    }
} 
