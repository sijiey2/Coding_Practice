// DFS (Recursion)
// Key words: Return all possible combinations
// Idea: for each pos, try nums from 1 ~ n (no duplicaties)
// 21ms (3ms)

import java.util.List;
import java.util.ArrayList;

public class Solution {
	List<List<Integer>> result = new ArrayList<List<Integer>>();

	public List<List<Integer>> combine(int n, int k ) {	
		List<Integer> temp = new ArrayList<Integer>();

		explore(n, k, temp, 1);
		return result;
	}

	public void explore(int n, int k, List<Integer> temp, int start) {
		if (k == temp.size()) {
			result.add(new ArrayList<Integer>(temp));
		}

		for (int i = start; i <= n; i++) {
			temp.add(i);
			explore(n, k, temp, i+1);
			temp.remove(temp.size()-1);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.combine(4, 2);
	}
}
