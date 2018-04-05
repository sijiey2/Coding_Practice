// LL (Non-R)
// two pointers (prev, cur)
// attention on ex. ([1] 1) no previous 
// 16ms (12ms)

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode removeNthFromEnd(ListNode head, int n) {
		if (head == null) {
            return null;
        }
        ListNode prev = head;
        ListNode cur = prev;
        int count = 0;
        
        while (cur != null) {
            while (cur != null && count < n) {
                cur = cur.next;
                count++;
            }
            if (cur == null) {
                return prev.next; // attention
            }
            if (cur != null && cur.next == null) {
                prev.next = prev.next.next;
                break;
            }
            count = 0;
            prev = prev.next;
            cur = prev;
        }
        return head;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head = sol.removeNthFromEnd(head, 2);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
