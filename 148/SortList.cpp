#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* sortList(ListNode* head) {
        if (!head)
            return NULL;
        else if (!head->next)
            return head;
        ListNode *p = head, *q = p->next;
        while (q) {
            q = q->next;
            if (q) {
                p = p->next;
                q = q->next;
            }
        }
        q = p->next;
        p->next = NULL;
        ListNode *h1 = sortList(head);
        ListNode *h2 = sortList(q);
        ListNode *h = new ListNode(0), *h0 = h;
        while (h1 && h2) {
            if (h1->val < h2->val) {
                h0->next = h1;
                h1 = h1->next;
            } else {
                h0->next = h2;
                h2 = h2->next;
            }
            h0 = h0->next;
            h0->next = NULL;
        }
        if (h1)
            h0->next = h1;
        if (h2)
            h0->next = h2;
        return h->next;
    }
};
