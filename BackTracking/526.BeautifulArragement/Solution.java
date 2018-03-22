// DFS (Recursion)
// Key words: How many beautiful arrangements
// Idea: for each num, try each position
//       deal with duplicates: int[] visited
// 105ms (2ms) - can be faster

public class Solution {
	int result = 0;

	public int countArrangement(int N) {
		if (N == 0) {
			return 0;
		}

		explore(N, 1, new int[N + 1]);
		return result;
	}

	public void explore(int N, int num, int[] visited) { // for each num, try each position
		if (num == N + 1) {
			result++;
			return;
		}

		for (int i = 1; i <= N; i++) { // i is position
			if (visited[i] == 0 && (i % num == 0 || num % i == 0)) {
				visited[i] = 1;
				explore(N, num + 1, visited);
				visited[i] = 0;
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.countArrangement(2));
	}
}
