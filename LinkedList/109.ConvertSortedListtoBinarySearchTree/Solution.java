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
		if (head == null) {
            return null;
        }
        if (head.next == null) {
            return new TreeNode(head.val);
        }
        if (head.next.next == null) {
            TreeNode root = new TreeNode(head.next.val);
            root.left = new TreeNode(head.val);
            return root;
        }
        ListNode walker = head;
        ListNode runner = head;
        ListNode prev = walker;
        
        // get mid
        while (runner.next != null && runner.next.next != null) {
            prev = walker;
            walker = walker.next;
            runner = runner.next.next;
        }
        
        // create tree
        TreeNode root = new TreeNode(walker.val);
        ListNode right = walker.next;
        prev.next = null;
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
