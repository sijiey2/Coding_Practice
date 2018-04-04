// LL (Non-R)
// stack
// 69ms (44ms)

import java.util.Stack;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode result = new ListNode(0);
        int carry = 0;
        
        // create stacks
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        
        // add
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int sum = 0;
            if (!stack1.isEmpty()) {
                sum += stack1.pop();
            }
            if (!stack2.isEmpty()) {
                sum += stack2.pop();
            }
            sum += carry;
            carry = sum / 10;
            result = addToFront(result, sum % 10);
        }
        
        if (carry != 0) {
            result.val = 1;
            return result;
        } 
        return result.next;
	}

	// add node to the front of the link
	public ListNode addToFront(ListNode head, int num) {
        ListNode next = head.next;
        head.next = new ListNode(num);
        head.next.next = next;
        return head;
    }

	public static void main(String[] args) {
		Solution sol = new Solution();
		ListNode l1 = new ListNode(7);
		l1.next = new ListNode(2);
		l1.next.next = new ListNode(4);
		l1.next.next.next = new ListNode(3);
		ListNode l2 = new ListNode(5);
		l2.next = new ListNode(6);
		l2.next.next = new ListNode(4);
		ListNode head = sol.addTwoNumbers(l1, l2);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}
}
