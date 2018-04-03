// DFS (Recursion)
// 2ms (1ms)

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}

		if (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) {
			return isBalanced(root.left) && isBalanced(root.right);
		}
		return false;
	}

	public int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}

		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(sol.isBalanced(root));
	}
}
