// LL (Non-R)
// get the length -> get the sub lists
// 5ms (4ms)

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        if (root == null) {
            return result;
        }
        ListNode cur = root;
        
        // get length
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len += 1;
        }
        
        // get sub lists
        int quotient = len / k;
        int remainder = len % k;
        int i = 0;
        
        while (i < k) {
            // create a sub list
            ListNode dummy = new ListNode(0);
            int size = 0;
            
            cur = dummy;
            while (root != null && size < quotient) {
                cur.next = root;
                cur = cur.next;
                root = root.next;
                size++;
            }
            if (remainder > 0) {
                cur.next = root;
                cur = cur.next;
                root = root.next;
                remainder--;
            }
            cur.next = null;
            result[i] = dummy.next;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        ListNode[] result = sol.splitListToParts(head, 5);
    }
}


