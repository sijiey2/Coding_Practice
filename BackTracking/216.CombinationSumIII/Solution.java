// DFS (Recursion)
// Key words: Find all possible combinations 
// Idea: for each pos, try num from 1 to 9 (no duplicate)

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum3(int k, int n) {
		explore(k, n, new ArrayList<Integer>(), 1);
		return result;
	}

	public void explore(int k, int n, List<Integer> each, int start) {
		if (n < 0) {
			return;
		}
		if (k == 0) {
			if (n == 0) {
				result.add(new ArrayList<Integer>(each));
			}
			return;
		}

		for (int i = start; i <= 9; i++) {
			each.add(i);
			explore(k - 1, n - i, each, i + 1);
			each.remove(each.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.combinationSum3(3, 9);
	}
}
