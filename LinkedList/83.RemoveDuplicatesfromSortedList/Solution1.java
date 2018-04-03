// LL (Recursion)
// 2ms (1ms)

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution1 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        head.next = deleteDuplicates(head.next);
        if (head.val == head.next.val) {
            return head.next;
        } else {
            return head;
        }
    }

    public static void main(String[] args) {
		Solution1 sol = new Solution1();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		sol.deleteDuplicates(head);
	}
}
