#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* swapPairs(ListNode* head) {
        ListNode *h = head, *prev = NULL, *p = head, *q;
        while (p != NULL) {
            q = p->next;
            if (q == NULL)
                break;
            if (prev == NULL)
                h = q;
            else
                prev->next = q;
            p->next = q->next;
            q->next = p;
            prev = p;
            p = p->next;
        }
        return h;
    }
};

int main() {
    Solution solu;
    ListNode* head = new ListNode(3);
    ListNode* res = solu.swapPairs(head);
    while (res != NULL) {
        std::cout<<res->val;
        res = res->next;
    }
}
