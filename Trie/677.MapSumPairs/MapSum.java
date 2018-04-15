// Trie
// 132ms (96ms)

class TrieNode {
	TrieNode[] children = new TrieNode[26];
	int val = 0;
}

public class MapSum {
	TrieNode root;
	int sum = 0;

	public MapSum() {
		root = new TrieNode();
	}

	// create Trie
	public void insert(String key, int val) {
		TrieNode cur = root;

		for (char c: key.toCharArray()) {
			if (cur.children[c - 'a'] == null) {
				cur.children[c - 'a'] = new TrieNode();
			}
			cur = cur.children[c - 'a'];
		}
		cur.val = val;
	}

	// search prefix and add sum
	public int sum(String prefix) {
		TrieNode cur = root;

		for (char c: prefix.toCharArray()) {
			if (cur.children[c - 'a'] == null) {
				return 0;
			}
			cur = cur.children[c - 'a'];
		}
		return explore(cur);
	}

 	// add sum
	public int explore(TrieNode root) {
		int sum = 0;

		for (int i = 0; i < 26; i++) {
			if (root.children[i] == null) {
				continue;
			}
			sum += explore(root.children[i]);
		}
		return sum + root.val;
	}

	public static void main(String[] args) {
		MapSum ms = new MapSum();
		ms.insert("apple", 3);
		System.out.println(ms.sum("ap"));
		ms.insert("app", 2);
		System.out.println(ms.sum("ap"));
	}
}
