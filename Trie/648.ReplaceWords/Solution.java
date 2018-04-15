// Trie
// 29ms (24ms)

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class TrieNode {
	TrieNode[] children = new TrieNode[26];
	String word = "";
}

public class Solution {
	public String replaceWords(List<String> dict, String sentence) {
		TrieNode root = new TrieNode();
		TrieNode cur = root;

		// create Trie
		for (String word: dict) {
			for (char c: word.toCharArray()) {
				if (cur.children[c - 'a'] == null) {
					cur.children[c - 'a'] = new TrieNode();
				}
				cur = cur.children[c - 'a'];
			}
			cur.word = word;
			cur = root;
		}

		// search and replace
		String[] words = sentence.split(" ");
		for (int i = 0; i < words.length; i++) {
			for (char c: words[i].toCharArray()) {
				if (cur.children[c - 'a'] == null) {
					break;
				}
				cur = cur.children[c - 'a'];
				if (!cur.word.equals("")) {
					words[i] = cur.word;
					break;
				}
			}
			cur = root;
		}
		return String.join(" ", words);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		List<String> dict = new ArrayList(Arrays.asList("cat", "bat", "rat"));
		String sentence = "the cattle was rattled by the battery";
		System.out.println(sol.replaceWords(dict, sentence));
	}
}
