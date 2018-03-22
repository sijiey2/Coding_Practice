// DFS (Recursion)
// Key words: Return a list of all possible strings
// Idea: for each char, we either make it upper case or lower case
// 10ms (8ms)
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {
	List<String> result = new ArrayList<>();

	public List<String> letterCasePermutation(String S) {
		if (S == null) {
			return result;
		}

		explore(S, 0);
		return result;
	}

	public void explore(String S, int i) {
		if (i == S.length()) {
			result.add(S);
			return;
		}

		if (Character.isDigit(S.charAt(i))) {
			explore(S, i + 1);
			return;
		}
		char[] chrs = S.toCharArray();
		chrs[i] = Character.toLowerCase(chrs[i]);
		explore(String.valueOf(chrs), i + 1);

		chrs[i] = Character.toUpperCase(chrs[i]);
		explore(String.valueOf(chrs), i + 1);
	}

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		sol.letterCasePermutation("a1b2");
	}
}
