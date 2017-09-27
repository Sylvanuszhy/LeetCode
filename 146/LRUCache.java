import java.util.HashMap;

class LRUCache {

    class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
        ListNode(int key, int val) { this.key = key; this.val = val; }
    }

    int capacity;
    int count;
    HashMap map;
    ListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        count = 0;
        map = new HashMap<Integer, ListNode>();
        head = new ListNode(0, 0);
        tail = new ListNode(0, 0);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        ListNode node = (ListNode)map.get(key);
        if (node != null) {
            node = remove(node);
            add(node);
            return node.val;
        } else {
            return -1;
        }
    }
    
    public void put(int key, int value) {
        ListNode node = (ListNode)map.get(key);
        if (node != null) {
            node = remove(node);
            node.val = value;
        } else {
            node = new ListNode(key, value);
            map.put(key, node);
            if (count<capacity) {
                count++;
            } else {
                ListNode tmp = remove(head.next);
                map.remove(tmp.key);                    // why tmp = null doesnot work
            }
        }
        add(node);
    }

    public ListNode remove(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        return node;
    }

    public void add(ListNode node) {
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
