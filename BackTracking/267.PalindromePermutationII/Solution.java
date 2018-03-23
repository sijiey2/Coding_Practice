// DFS (Recursion)
// Key words: return all the palindromic permutations
// Idea: for each pos, try each num (reverse for the other half)
// 6ms (4ms)

import java.util.List;
import java.util.ArrayList;

public class Solution {
	List<String> result = new ArrayList<>();

	public List<String> generatePalindromes(String s) {
		int count = 0;
		int[] freqs = new int[256];

		// get odd num
		for (char c: s.toCharArray()) {
			freqs[c]++;
			if (freqs[c] % 2 == 1) {
				count++;
			} else {
				count--;
			}
		}
		if (count > 1) {
			return result;
		}

		String mid = "";
		int length = 0;

		// get mid (count is odd)
		for (int i = 0; i < 256; i++) {
			if (freqs[i] > 0) {
				if (freqs[i] % 2 == 1) {
					mid = "" + (char)i; // attention: (char)i instead of i
					freqs[i]--;
				}
			}
			freqs[i] /= 2;
			length += freqs[i];
		}
		explore(freqs, length, "", mid);
		return result;
	}

	public void explore(int[] freqs, int length, String each, String mid) {
		if (each.length() == length) {
			StringBuilder reverse = new StringBuilder(each).reverse();
			result.add(each + mid + reverse);
			return;
		}

		for (int i = 0; i < 256; i++) {
			if (freqs[i] > 0) {
				freqs[i]--;
				explore(freqs, length, each + (char)i, mid);
				freqs[i]++;
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		sol.generatePalindromes("aadbb");
	}
}
