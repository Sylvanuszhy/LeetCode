import java.util.Comparator;
import java.util.PriorityQueue;

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
            public int compare(ListNode node1, ListNode node2) {
                return node1.val-node2.val;
            }
        });
        for (int i = 0; i<lists.length; i++)
            if (lists[i] != null)
                heap.add(lists[i]);
        ListNode head = new ListNode(0);
        ListNode p = head;
        while (!heap.isEmpty()) {
            ListNode node = heap.remove();
            p.next = node;
            p = p.next;
            node = node.next;
            if (node != null)
                heap.add(node);
        }
        return head.next;
    }
}
