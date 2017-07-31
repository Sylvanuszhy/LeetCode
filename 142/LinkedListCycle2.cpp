#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode *oneStep = head, *twoStep = oneStep;
        while (twoStep) {
            oneStep = oneStep->next;
            twoStep = twoStep->next;
            if (twoStep)
                twoStep = twoStep->next;
            if (oneStep == twoStep)
                break;
        }
        if (twoStep) {
            ListNode *p = head, *q = oneStep;
            while (p != q) {
                p = p->next;
                q = q->next;
            }
            return p;
        } else {
            return NULL;
        }
    }
};

int main() {
    Solution solu;
    solu.detectCycle(new ListNode(0));
}
