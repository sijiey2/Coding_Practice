// DFS (Recursion - D&C)
// Key words: n/a
// Idea: for each pos as the start, check wether the rest loses
// 176ms (1ms) -can be much faster

public class Solution {

	public boolean canWin(String s) {
		if (s == null || s.length() < 2) return false;

		for (int i = 0; i < s.length() -1; i++) {
			if (s.startsWith("++", i)) {
				String t = s.substring(0, i) + "--" + s.substring(i+2);

				if (!canWin(t)) {
					return true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		System.out.println(sol.canWin("++++++"));
	}
}
