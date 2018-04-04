// LL (Recursion)
// Ex: 1->2->3->4
// next => 2->3->4
// head => 1->3->4
// next.next => 2->(1->3->4)
// 5ms (4ms)

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode swapPairs(ListNode head) {
		if (head == null || head.next == null) {
            return head;
        }
        
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(5);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head = sol.swapPairs(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
