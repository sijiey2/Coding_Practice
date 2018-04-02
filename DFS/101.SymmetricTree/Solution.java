// DFS (Recursion)
// 16ms (12ms)

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode (int x) { val = x; }
}

public class Solution {
	public boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		return explore(root.left, root.right);
	}

	public boolean explore(TreeNode left, TreeNode right) {
		if (left == null || right == null) {
			return left == null && right == null;
		}

		if (left.val == right.val) {
			return explore(left.left, right.right) && explore(left.right, right.left);
		}
		return false;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		System.out.println(sol.isSymmetric(root));
	}
}
