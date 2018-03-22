// DFS (Recursion)
// Key words: Find all unique combinations
// Idea: for each pos, try a num (contains duplicates)
// 21ms (14ms)

import java.util.List;
import java.util.ArrayList;

public class Solution {
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		if (candidates == null || candidates.length == 0) {
			return result;
		}
		List<Integer> temp = new ArrayList<>();

		explore(candidates, target, temp, 0);
		return result;
	}

	public void explore(int[] candidates, int target, List<Integer> temp, int start) {
		if (target == 0) {
			result.add(new ArrayList(temp));
			return;
		}
		if (target < 0) {
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			temp.add(candidates[i]);
			explore(candidates, target - candidates[i], temp, i);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] candidates = {2,3,6,7};
		sol.combinationSum(candidates, 7);
	}
}
