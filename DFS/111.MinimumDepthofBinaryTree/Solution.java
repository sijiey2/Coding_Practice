// Recursion 
// 1ms(okay) -0ms

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public int minDepth(TreeNode root) {
		if (root == null) return 0;
		int left = minDepth(root.left);
		int right = minDepth(root.right);

		return (left == 0 || right == 0)? left + right + 1: Math.min(left, right) + 1;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(12);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(4);
		System.out.println(sol.minDepth(root));
	}
}
