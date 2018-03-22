// DFS (Recursion)
// Key words: Return all possible combinations 
// Idea: for each pos, try nums (start ~ n) (contains duplicates)
// Attention: set an upper bound can be much faster
// 192ms (1ms)

import java.util.List;
import java.util.ArrayList;

public class Solution1 {
	List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> getFactors(int n) {
		if (n <= 3) {
			return result;
		}

		explore(n, new ArrayList<Integer>(), 2, (int)Math.sqrt(n));
		return result;
	}

	public void explore(int n, List<Integer> each, int start, int upper) {
		if (n <= 1 && each.size() > 1) {
			result.add(new ArrayList<Integer>(each));
			return;
		}

		for (int i = start; i <= n; i++) {
			if (i > upper) {
				i = n;
			}
			if (n % i != 0) {
				continue;
			}
			each.add(i);
			explore(n / i, each, i, (int)Math.sqrt(n/i)); // attention: i instead of i + 1
			each.remove(each.size() - 1);
		}
	}
