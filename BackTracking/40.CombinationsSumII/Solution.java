// DFS (Recursion)
// Key words: find all unique combinations
// Idea: for each pos, try a num (have duplicates, no duplicates in results) 
// Attention: sort the array
// (similar as Prob.90)
// 25m (15ms)

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates); // attention
		explore(candidates, target, new ArrayList<Integer>(), 0);
		return result;
	}

	public void explore(int[] candidates, int target, List<Integer> temp, int start) {
		if (target == 0) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		if (target < 0) {
			return;
		}

		for (int i = start; i < candidates.length; i++) {
			if (i > start && candidates[i] == candidates[i - 1]) {
				continue; // attention
			}
			temp.add(candidates[i]);
			explore(candidates, target - candidates[i], temp, i + 1);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] candidates = {10,1,2,7,6,1,5};
		sol.combinationSum2(candidates, 8);
	}
}
