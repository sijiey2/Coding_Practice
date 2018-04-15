// Trie
// HashMap, bucket
// 28ms (19ms)

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

class TrieNode {
	TrieNode[] children = new TrieNode[26];
	String word = "";
}

public class Solution {
	public List<String> topKFrequent(String[] words, int k) {
		Map<String, Integer> map = new HashMap<>();
		TrieNode[] count = new TrieNode[words.length + 1];
		List<String> result = new ArrayList<>();

		// create map
		for (String word: words) {
			map.put(word, map.getOrDefault(word, 0) + 1);
		}

		// create bucket (for each freq, there is a trie)
		for (String word: map.keySet()) {
			int freq = map.get(word);

			if (count[freq] == null) {
				count[freq] = new TrieNode();
			}
			add(count[freq], word);
		}

		// get k frequent words
		for (int i = count.length - 1; i >= 1 && result.size() < k; i--) {
			if (count[i] == null) {
				continue;
			}
			get(count[i], result, k);
		}

		// print result
		for (int i = 0; i < result.size(); i++) {
			System.out.println(result.get(i));
		}
		return result;
	}

	public void add(TrieNode root, String word) {
		for (char c: word.toCharArray()) {
			if (root.children[c - 'a'] == null) {
				root.children[c - 'a'] = new TrieNode();
			}
			root = root.children[c - 'a'];
		}
		root.word = word;
	}

	public void get(TrieNode root, List<String> result, int k) {
		if (root == null) {
			return;
		}

		if (!root.word.equals("")) {
			result.add(root.word);
		}
		if (result.size() == k) {
			return;
		}
		for (int i = 0; i < 26; i++) {
			if (root.children[i] != null) {
				get(root.children[i], result, k);
			}
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		String[] words = {"i", "love", "leetcode", "i", "love", "coding"};
		sol.topKFrequent(words, 2);
	}
}
