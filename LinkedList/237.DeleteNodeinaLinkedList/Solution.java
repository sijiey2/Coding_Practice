// LL
// 1ms (1ms)

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public void delteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}
}
