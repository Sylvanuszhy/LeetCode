#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* insertionSortList(ListNode* head) {
        ListNode *h = new ListNode(0);
        h->next = head;
        ListNode *prevq = h, *q = head;
        while (q) {
            ListNode *prevp = h, *p = h->next;
            while (p != q) {
                if (p->val > q->val)
                    break;
                prevp = p;
                p = p->next;
            }
            if (p != q) {
                prevp->next = q;
                prevp = q;
                q = q->next;
                prevp->next = p;
                prevq->next = q;
            } else {
                prevq = q;
                q = q->next;
            }
        }
        return h->next;
    }
};
