#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    bool hasCycle(ListNode *head) {
        if (head == NULL)
            return false;
        ListNode *oneStep = head, *twoStep = head->next;
        while (twoStep) {
            if (oneStep == twoStep)
                return true;
            oneStep = oneStep->next;
            twoStep = twoStep->next;
            if (twoStep)
                twoStep = twoStep->next;
        }
        return false;
    }
};

int main() {
    Solution solu;
    solu.hasCycle(new ListNode(0));
}
