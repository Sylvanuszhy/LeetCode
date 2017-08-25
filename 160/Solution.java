public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p = headA, q = headB;
        while (p != q) {
            if (p == null)
                p = headB;
            else
                p = p.next;
            
            if (q == null)
                q = headA;
            else
                q = q.next;
        }
        return p;
    }
}
