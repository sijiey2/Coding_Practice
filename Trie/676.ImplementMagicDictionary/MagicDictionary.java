// Trie
// 132ms (96ms)

class TrieNode {
	TrieNode[] children = new TrieNode[26];
	boolean isWord = false;
}

public class MagicDictionary {
	TrieNode root;

	public MagicDictionary() {
		root = new TrieNode();
	}

	// create Trie
	public void buildDict(String[] dict) {
		TrieNode cur = root;

		for (String word: dict) {
			cur = root;
			for (char c: word.toCharArray()) {
				if (cur.children[c - 'a'] == null) {
					cur.children[c - 'a'] = new TrieNode();
				}
				cur = cur.children[c - 'a'];
			}
			cur.isWord = true;
		}
	}

	// replace each char with a ~ z and search
	public boolean search(String word) {
		char[] chrs = word.toCharArray();

		for (int i = 0; i < chrs.length; i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				if (chrs[i] == c) {
					continue;
				}

				char temp = chrs[i];
				chrs[i] = c;
				if (searchHelper(chrs)) {
					return true;
				}
				chrs[i] = temp;
			}
		}
		return false;
	}

	// search Trie
	public boolean searchHelper(char[] chrs) {
		TrieNode cur = root;

		for (char c: chrs) {
			if (cur.children[c - 'a'] == null) {
				return false;
			}
			cur = cur.children[c - 'a'];
		}
		return cur.isWord;
	}

	public static void main(String[] args) {
		MagicDictionary md = new MagicDictionary();
		String[] dict = {"hello","leetcode"};
		md.buildDict(dict);
		System.out.println(md.search("hello"));
		System.out.println(md.search("hhllo"));
		System.out.println(md.search("hell"));
		System.out.println(md.search("leetcoded"));
	}
}
