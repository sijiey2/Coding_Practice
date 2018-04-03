// LL
// prev, head, head.next
// 0ms

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode reverseList(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;

			prev = head;
			head = next;
		}
		return prev;
	}
}
