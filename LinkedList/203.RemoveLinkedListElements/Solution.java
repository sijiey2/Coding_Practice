// LL (Non-R)
// dummy node
// 2ms (1ms)

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy;
        
        while (cur != null && cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return dummy.next;
    }

	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		head = sol.removeElements(head, 2);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
