public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head, fast = slow.next;
        ListNode p = null;
        while (fast != null) {
            p = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }
        p.next = null;
        ListNode q = slow.next;
        while (q != null) {
            slow.next = p;
            p = slow;
            slow = q;
            q = slow.next;
        }
        slow.next = p;
        p = head;
        q = slow;
        while (p != null) {
            if (p.val != q.val)
                return false;
            p = p.next;
            q = q.next;
        }
        return true;
    }
}
