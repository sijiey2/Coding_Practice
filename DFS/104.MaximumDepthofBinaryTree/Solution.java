// DFS (Recursion -D&C)
// 1ms (0ms)

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x) { val = x; }
}

public class Solution {
	public int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(maxDepth(root.right), maxDepth(root.left));
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(sol.maxDepth(root));
	}
}
