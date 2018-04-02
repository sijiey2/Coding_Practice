// DFS (Recursion)
// 1ms (1ms)

import java.util.Queue;
import java.util.LinkedList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public TreeNode sortedArrayToBST(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}

		return buildTree(nums, 0, nums.length - 1);
	}

	public TreeNode buildTree(int[] nums, int start, int end) {
		if (start > end) {
			return null;
		}

		int mid = start + (end - start) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = buildTree(nums, start, mid - 1);
		root.right = buildTree(nums, mid + 1, end);
		return root;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		int[] nums = {-10,-3,0,5,9};
		TreeNode root = sol.sortedArrayToBST(nums);
		if (root != null) {
			Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.offer(root);
			while (!q.isEmpty()) {
				TreeNode node = q.poll();
				System.out.println(node.val);
				if (node.left != null) q.offer(node.left);
				if (node.right != null) q.offer(node.right);
			}
		}
	}
}
