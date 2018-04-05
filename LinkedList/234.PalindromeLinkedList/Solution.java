// LL (Non-R)
// get mid and reverse
// 2ms (0ms)

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution1 {
	public boolean isPalindrome(ListNode head) {
		if (head == null) {
            return true;
        }
        ListNode walker = head;
        ListNode runner = head;
        
        // get mid point
        while (runner.next != null && runner.next.next != null) {
            walker = walker.next;
            runner = runner.next.next;
        }
        if (walker.next != null) {
            walker = walker.next;
        }
         
        // compare
        ListNode right = reverse(walker);
        while (right != null) {
            if (head.val != right.val) {
                return false;
            }
            head = head.next;
            right = right.next;
        }
        return true;     
    }
    
    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            
            prev = head;
            head = next;    
        }
        return prev;
    }
	}

	public ListNode reverse(ListNode head) {
		ListNode prev = null;

		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(2);
		head.next.next.next = new ListNode(1);
		System.out.println(sol.isPalindrome(head));
	}
}
