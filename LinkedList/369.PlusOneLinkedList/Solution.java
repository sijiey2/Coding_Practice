// LL (Recursion)
// recursion by carry
// 1ms (0ms)

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode plusOne(ListNode head) {
        if (explore(head) == 0) {
            return head;
        } else {
            ListNode dummy = new ListNode(1);

            dummy.next = head;
            return dummy;
        }
    }
    
    public int explore(ListNode head) {
        if (head == null) {
            return 1;
        } 
        int carry = explore(head.next);
        
        if (carry == 0) {
            return 0;
        } else {
            int sum = head.val + carry;

            head.val = sum % 10;
            return sum / 10;
        }
    }

	public static void main(String[] args) {
		Solution sol = new Solution();
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
