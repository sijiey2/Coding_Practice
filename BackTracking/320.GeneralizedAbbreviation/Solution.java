// DFS (Recursion)
// Key words: generate (all) the generalized abbreviations
// Idea: for each pos, either abbrev or not
//       - abbrev: count++, skip the char
//       - not abbrev: count = 0, add the char
// Attention: StringBuilder is faster than String for appending,
//            char[] word is faster than String word for accessing
// (StringBuilder -> setLength for backtracking)
// 16ms (11ms)

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution1 {
	List<String> result = new ArrayList<>();

	public List<String> generateAbbreviations(String word) {
		explore(word.toCharArray(), 0, new StringBuilder(), 0);
		return result;
	}

	public void explore(char[] word, int start, StringBuilder each, int count) {
		int len = each.length();

		if (start == word.length) {
			if (count > 0) {
				each.append(count);
			}
			result.add(each.toString());
		} else {
            explore(word, start + 1, each, count + 1);

            if (count > 0) {
                each.append(count);
            }
            explore(word, start + 1, each.append(word[start]), 0);
        }
		each.setLength(len); // attention: apply on both if and else
	}

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		sol.generateAbbreviations("word");
		// sol.generateAbbreviations("");
		sol.generateAbbreviations("pragmatically");
	}
}
