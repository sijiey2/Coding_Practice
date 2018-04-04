// LL (Non-R)
// 1ms (0ms)

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode oddEvenList(ListNode head) {
		if (head == null) {
            return null;
        }
        ListNode curO = head;
        ListNode curE = head.next;
        ListNode evenHead = curE; // attention
        
        while (curE != null && curE.next != null) {
            curO.next = curO.next.next;
            curE.next = curE.next.next;
            curO = curO.next;
            curE = curE.next;
        }
        curO.next = evenHead;
        return head; 
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head = sol.oddEvenList(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
