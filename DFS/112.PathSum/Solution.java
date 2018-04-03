// DFS (Recursion)
// 1ms (0ms)

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null) {
			return false;
		}
        if (root.left == null && root.right == null) {
            return sum - root.val == 0;
        }

		return hasPathSum(root.left, sum - root.val) ||
			hasPathSum(root.right, sum - root.val);
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(2);
		System.out.println(sol.hasPathSum(root, 22));
	}
}
