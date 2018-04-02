// DFS (Recursion) - Backtracking
// 17ms (14ms)

import java.util.List;
import java.util.ArrayList;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	List<String> result = new ArrayList<String>();

	public List<String> binaryTreePaths(TreeNode root) {
		if (root == null) {
			return result;
		}

		explore(root, new StringBuilder());
		return result;
	}

	public void explore(TreeNode root, StringBuilder temp) {
		if (root.left == null && root.right == null) {
			temp.append(root.val);
			result.add(temp.toString());
			return;
		}

		temp.append(root.val + "->");
		int len = temp.length();
		if (root.left != null) {
			explore(root.left, temp);
		}
		temp.setLength(len);
		if (root.right != null) {
			explore(root.right, temp);
		}	
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		sol.binaryTreePaths(root);
	}
}
