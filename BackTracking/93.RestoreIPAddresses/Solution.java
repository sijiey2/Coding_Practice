// DFS (Recursion)
// Key words: Returning all possible valid IP address combinations
// Idea: for each pos, get the following nums (1 ~ 3)
// 5ms (1ms)

import java.util.List;
import java.util.ArrayList;

public class Solution {
	List<String> result = new ArrayList<>();

	public List<String> restoreIpAddresses(String s) {
		explore(s, "", 0, 0);
		return result;
	}

	public void explore(String s, String temp, int start, int count) {
		if (count > 4) {
			return;
		}
		if (count == 4 && start == s.length()) {
			result.add(temp);
		}

		for (int i = 1; i < 4; i++) {
			if (start + i > s.length()) {
				break;
			}
			String part = s.substring(start, start + i);

			if ((part.startsWith("0") && part.length() > 1) ||
				(i == 3 && Integer.parseInt(part) >= 256)) { // attention
				continue;
			}
			explore(s, temp + part + (count == 3? "": "."), start + i, count + 1);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.restoreIpAddresses("25525511135");
	}
}
