#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *h = NULL;
        ListNode *p = NULL;

        int carry = 0;
        while (l1 != NULL || l2 != NULL) {
            int val1 = 0, val2 = 0;
            if (l1 != NULL) {
                val1 = l1->val;
            }
            if (l2 != NULL) {
                val2 = l2->val;
            }

            int val = val1 + val2 + carry;
            ListNode *node = new ListNode(val%10);
            carry = val/10;
            if (h == NULL) {
                h = node;
                p = h;
            } else {
                p->next = node;
                p = p->next;
            }

            if (l1 != NULL) {
                l1 = l1->next;
            }
            if (l2 != NULL) {
                l2 = l2->next;
            }
        }

        if (carry>0) {
            ListNode *node = new ListNode(carry);
            p->next = node;
        }
        return h;
    }
};

int main() {
    Solution solu;
    ListNode* num1 = new ListNode(3);
    ListNode* num2 = new ListNode(7);
    ListNode* res = solu.addTwoNumbers(num1, num2);
    while (res != NULL) {
        std::cout<<res->val;
        res = res->next;
    }
}
