// LL (Non-R && R)
// get mid (walker and runner)
// 2ms (1ms)

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class Solution {
	public TreeNode sortedListToBST(ListNode head) {
		if (head == null) return null;
		if (head.next == null) return new TreeNode(head.val);
		if (head.next.next == null) {
			TreeNode root = new TreeNode(head.next.val);
			root.left = new TreeNode(head.val);
			return root;
		}
		ListNode slow = head;
		ListNode fast = head;
		ListNode prev = slow; // attention (track prev of slow)

		// get middle point
		while (fast.next != null && fast.next.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		// create tree (root/left/right)
		TreeNode root = new TreeNode(slow.val);
		ListNode right = slow.next;
		prev.next = null; // instead of slow.next = null
		root.left = sortedListToBST(head);
		root.right = sortedListToBST(right);
		return root;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		sol.sortedListToBST(head);
	}
}
