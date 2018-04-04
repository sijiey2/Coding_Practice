// LL (Non-R)
// two pointers
// 1ms (0ms)

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution1 {
	public ListNode plusOne(ListNode head) {
		if (head == null) {
            return new ListNode(1);
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur1 = dummy;
        ListNode cur2 = dummy;
        
        // get the last non-9 num
        while (cur1 != null) {
            if (cur1.val != 9) {
                cur2 = cur1;
            }
            cur1 = cur1.next;
        }
        cur2.val += 1;
        cur2 = cur2.next;
        
        // set the rest num to 0
        while (cur2 != null) {
            cur2.val = 0;
            cur2 = cur2.next;
        }

        // get result
        if (dummy.val == 0) {
            return dummy.next;
        }
        return dummy;
	}

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		ListNode head = new ListNode(1);
		head.next = new ListNode(3);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(2);
		head = sol.plusOne(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
