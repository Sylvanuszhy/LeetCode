public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode h = new ListNode(0);
        h.next = head;
        reverse(h, k);
        return h.next;
    }

    public void reverse(ListNode t, int k) {
        ListNode p = t;
        for (int i = 0; i<k; i++) {
            p = p.next;
            if (p == null)
                return;
        }
        p = t.next;
        ListNode q = p.next, r;
        for (int i = 1; i<k; i++) {
            r = q.next;
            q.next = p;
            p = q;
            q = r;
        }
        r = t.next;
        r.next = q;
        t.next = p;
        reverse(r, k);
    }
}
