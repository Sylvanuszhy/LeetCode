#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode *p = head, *q = p;
        while (q != NULL) {
            if (p->val != q->val) {
                p->next = q;
                // memory leak
                p = q;
            }
            q = q->next;
        }
        if (p != NULL)
            p->next = q;
        return head;
    }
};
