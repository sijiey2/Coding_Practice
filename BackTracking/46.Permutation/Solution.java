// DFS (Recursion)
// Key words: Return all possible permutations
// Idea: for each pos, try a num (no duplicates)
//       duplicates: use 'contains' to check

import java.util.List;
import java.util.ArrayList;

public class Solution {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> permute(int[] nums) {	
		if (nums == null || nums.length == 0) return result;
		List<Integer> each = new ArrayList<Integer>();

		explore(nums, each);
		return result;
	}	

	public void explore(int[] nums, List<Integer> each) {
		if (each.size() == nums.length) {
			result.add(new ArrayList<Integer>(each));
		}

		for (int i = 0; i < nums.length; i++) {
			if (each.contains(nums[i])) {
				continue; // check duplicates
			}
			each.add(nums[i]);
			explore(nums, each);
			each.remove(each.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {1,2,3};
		sol.permute(nums);
	}
}
