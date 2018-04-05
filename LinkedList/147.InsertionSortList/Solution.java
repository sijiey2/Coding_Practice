// LL (Non-R)
// create a new linkedlist, two pointers
// 35ms (4ms)

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution1 {
	public ListNode insertionSortList(ListNode head) {
		if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur1 = dummy;
        ListNode cur2 = head;
        
        while (cur2 != null) {
            while (cur1.next != null && cur1.next.val < cur2.val) {
                cur1 = cur1.next;
            }
            ListNode next = cur1.next;
            cur1.next = new ListNode(cur2.val);
            cur1.next.next = next;
            cur2 = cur2.next;
            cur1 = dummy;
        }
        return dummy.next;
	}

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		ListNode head = new ListNode(3);
		head.next = new ListNode(2);
		head.next.next = new ListNode(4);
		head = sol.insertionSortList(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
