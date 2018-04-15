// Trie
// + recursion
// 17ms (14ms)

class TrieNode {
	TrieNode[] children = new TrieNode[26];
	String word = "";
}

public class Solution {
	TrieNode root = new TrieNode();
	String result = "";

	public String longestWord(String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}
		TrieNode cur = root;

		// create trie
		for (String word: words) {
			for (char w: word.toCharArray()) {
				if (cur.children[w - 'a'] == null) {
					cur.children[w - 'a'] = new TrieNode();
				}
				cur = cur.children[w - 'a'];
			}
			cur.word = word;
			cur = root;
		}

		// explore trie
		explore(cur);
		return result;
	}

	public void explore(TrieNode root) {
		TrieNode cur = root;

		for (int i = 0; i < 26; i++) {
			cur = root;
			if (cur.children[i] == null || cur.children[i].word.equals("")) {
				continue;
			}

			cur = cur.children[i];
			String word = cur.word;
			if (word.length() > result.length()) {
				result = word;
				System.out.println(result);
			}
			explore(cur);	
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		// String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
		String[] words = {"m","mo","moc","moch","mocha","l","la","lat","latt","latte","c","ca","cat"};
		System.out.println(sol.longestWord(words));
	}
}
