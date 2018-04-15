// Trie
// num & 1 => get the last digit
// num ^ 1 => get the opposite of the last digit
// 79ms (8ms)

class TrieNode {
	TrieNode[] children = new TrieNode[2];
}

public class Solution {
	public int findMaximumXOR(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}

		TrieNode root = new TrieNode();
		TrieNode cur = root;

		// create Trie
		for (int n: nums) {
			for (int i = 31; i >= 0; i--) {
				int curBit = (n >>> i) & 1;

				if (cur.children[curBit] == null) {
					cur.children[curBit] = new TrieNode();
				}
				cur = cur.children[curBit];
			}
			cur = root;
		}

		// get max
		int max = Integer.MIN_VALUE;
		for (int n: nums) {
			int curSum = 0;

			for (int i = 31; i >= 0; i--) {
				int curBit = (n >>> i) & 1; // get the cur bit

				if (cur.children[curBit ^ 1] != null) {
					curSum += (1 << i); // get the original position (value)
					cur = cur.children[curBit ^ 1];
				} else {
					cur = cur.children[curBit];
				}
			}
			max = Math.max(curSum, max);
			cur = root;
		}
		return max;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {3,10,5,25,2,8};
		System.out.println(sol.findMaximumXOR(nums));
		System.out.println(Integer.toBinaryString(28));
		System.out.println(Integer.toBinaryString(25));
		System.out.println(Integer.toBinaryString(5));
	}
}
