// DFS (Recursion)
// Key words: return all possible subsets
// Idea: for each pos, try a num (have duplicates, no duplicates in results)
// Attentions: sort the array
// 4ms (3ms)

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> subsetsWithDup(int[] nums) {
		if (nums == null || nums.length == 0) {
			return result;
		}
		List<Integer> temp = new ArrayList<>();

		Arrays.sort(nums); // attention
		explore(nums, temp, 0);
		return result;
	}

	public void explore(int[] nums, List<Integer> temp, int start) {
		result.add(new ArrayList<Integer>(temp));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			temp.add(nums[i]);
			explore(nums, temp, i + 1);
			temp.remove(temp.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {1,2,2};
		sol.subsetsWithDup(nums);
	}
}
