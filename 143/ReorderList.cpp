#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    void reorderList(ListNode* head) {
        ListNode *p = head, *q = p;
        while (q) {
            p = p->next;
            q = q->next;
            if (q)
                q = q->next;
        }

        q = p;
        p = NULL;
        while (q) {
            ListNode *n = q->next;
            q->next = p;
            p = q;
            q = n;
        }

        q = p;
        p = head;
        while (q) {
            ListNode *pn = p->next;
            ListNode *qn = q->next;
            p->next = q;
            q->next = pn;
            p = pn;
            q = qn;
        }
        if (p)
            p->next = NULL;
    }
};
