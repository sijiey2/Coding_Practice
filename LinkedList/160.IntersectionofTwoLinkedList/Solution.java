// LL (Non-R)
// a + c and b + c 
// => (a + c) + (b + c) = (b + c) + (a + c)
// attention: loop end end at the intersection or at null
// 2ms (okay) - 1ms

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
		next = null;
	}
}

public class Solution1 {
	public ListNode genIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
            return null;
        }
        ListNode curA = headA;
        ListNode curB = headB;
        
        while (curA != curB) {
            if (curA == null) {
                curA = headB;
            } else {
                curA = curA.next;
            }
            if (curB == null) {
                curB = headA;
            } else {
                curB = curB.next;
            }
        }
        return curA;
	}

	public static void main(String[] args) {
		Solution1 sol = new Solution1();
		ListNode headA = new ListNode(1);
		ListNode headB = new ListNode(2);
		headA.next = new ListNode (2);
		headA.next = headB;
		System.out.println(sol.genIntersectionNode(headA, headB).val);

	}
}
