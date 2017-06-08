#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* partition(ListNode* head, int x) {
        ListNode *less = new ListNode(x), *greater = new ListNode(x);
        ListNode *p = less, *q = greater, *k = head;
        while (k != NULL) {
            if (k->val < x) {
                p->next = k;
                p = p->next;
            } else {
                q->next = k;
                q = q->next;
            }
            k = k->next;
        }
        p->next = greater->next;
        q->next = NULL;
        return less->next;
    }
};
