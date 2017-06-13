#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode *h = new ListNode(0);
        h->next = head;
        ListNode *prev = h, *p = head, *q = p;
        while (q != NULL) {
            if (p->val != q->val) {
                if (p->next == q) {
                    prev = p;
                    p = q;
                } else {
                    p = q;
                    prev->next = p;
                }
            }
            q = q->next;
        }
        if (p != NULL && p->next != q)
            prev->next = q;
        return h->next;
    }
};
