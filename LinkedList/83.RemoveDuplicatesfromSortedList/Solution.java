// LL (Recursion)
// 2ms (1ms)

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode deleteDuplicates(ListNode head) {
		    if (head == null) {
            return head;
        }
        ListNode dummy = head;
        
        while (head != null && head.next != null) {
            if (head.val == head.next.val) {
                head.next = head.next.next;
            } else {
                head = head.next;
            }
        }
        return dummy;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		sol.deleteDuplicates(head);
	}
}
