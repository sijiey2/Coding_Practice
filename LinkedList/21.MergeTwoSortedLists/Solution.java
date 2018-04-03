// LL (Recursion)
// no extra ListNode
// 19ms (13ms)

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;

		if (l1.val < l2.val) {
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else {
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode l1 = new ListNode(4);
		ListNode l2 = new ListNode(2);
		sol.mergeTwoLlists(l1, l2);
	}
}
