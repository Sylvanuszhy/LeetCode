public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode prev = h, p = head;
        while (p != null) {
            if (p.val == val)
                prev.next = p.next;
            else
                prev = p;
            p = p.next;
        }
        return h.next;
    }
}
