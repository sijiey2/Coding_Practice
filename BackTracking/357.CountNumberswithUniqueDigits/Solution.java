// DFS (Recursion)
// Key words: count all numbers
// Idea: for each pos, try num from 1 to 9 (no duplicates)
//       duplicates (use 'contains')
/ 161ms (0ms) -very slow. can be much faster with DP

import java.util.List;
import java.util.ArrayList;

public class Solution {
	int count = 0;

	public int countNumbersWithUniqueDigits(int n) {
		explore(n, new ArrayList<Integer>(), 0);
		return count;
	}

	public void explore(int n, List<Integer> each, int start) {
		count++;
		if (start == n) {
			return;
		}

		for (int i = 0; i <= 9; i++) {
			if (start == 0 && i == 0 || 
				each.contains(i)) {
				continue;
			}
			each.add(i);
			explore(n, each, start + 1);
			each.remove(each.size() - 1);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.countNumbersWithUniqueDigits(2));
	}
}
