// DFS (Recursion)
// 5ms (4ms)

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null) {
			return p == null && q == null;
		}

		if (p.val == q.val) {
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);
		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.right = new TreeNode(3);
		System.out.println(sol.isSameTree(p, q));
	}
}
