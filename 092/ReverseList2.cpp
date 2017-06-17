#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* reverseBetween(ListNode* head, int m, int n) {
        ListNode *eh = new ListNode(0);
        eh->next = head;
        ListNode *h = eh;
        for (int i = 1; i<m; i++)
            h = h->next;
        ListNode *t = h->next, *p = t, *q = p->next;
        for (int i = 0; i<n-m; i++) {
            ListNode *prev = p;
            p = q;
            q = p->next;
            p->next = prev;
        }
        h->next = p;
        t->next = q;
        return eh->next;
    }
};
