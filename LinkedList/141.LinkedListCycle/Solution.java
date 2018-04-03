// LL: cycle
// walker and runner
// runner will always catch walker if cycle 
// 1ms (0ms)

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution {
	public boolean hasCycle(ListNode head) {
		if (head == null) {
            return false;
        }
        ListNode walker = head;
        ListNode runner = head;
        
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
            if (walker == runner) {
                return true;
            }
        }
        return false;
	}

	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode head = new ListNode(1);
		head.next = new ListNode(4);
		head.next = head;
		System.out.println(sol.hasCycle(head));
	}
}
