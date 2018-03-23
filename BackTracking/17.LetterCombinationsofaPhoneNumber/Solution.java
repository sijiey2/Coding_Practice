// DFS (Recursion)
// Key words: return all possible letter combinations
// Idea: for each pos, try each char in the corresponding key string

import java.util.List;
import java.util.LinkedList;

public class Solution {
	String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    List<String> result = new LinkedList<String>();

	public List<String> letterCombinations(String digits) {
		if (digits == null || digits.length() == 0) {
			return result;
		}

		explore("", digits, 0);
		return result;
	}

	public void explore(String temp, String digits, int start) {
		if (start == digits.length()) {
			result.add(temp);
			return;
		}
		String letters = KEYS[(digits.charAt(start) - '0')];
		for (int i = 0; i < letters.length(); i++) {
			explore(temp + letters.charAt(i), digits, start + 1);
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.letterCombinations("23");
	}
}
