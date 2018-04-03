// LL (Non-recursion)
// Create a new ListNode
// Move Two pointers 
// 15ms (12ms)

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {	
		ListNode node = new ListNode(0);
		ListNode node_cp = node;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				node.next = new ListNode(l1.val);
				node = node.next;
				l1 = l1.next;
			} else {
				node.next = new ListNode(l2.val);
				node = node.next;
				l2 = l2.next;
			}
		}

		if (l2 == null) {
			node.next = l1;
		} else {
			node.next = l2;
		}
		return node_cp.next;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(2);
		sol.mergeTwoLists(l1, l2);
	}
}
