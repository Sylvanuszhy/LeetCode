#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* mergeTwoLists(ListNode* l1, ListNode* l2) {
        ListNode *p1 = l1, *p2 = l2;
        ListNode *h = NULL;
        ListNode *p = NULL;
        while (p1 != NULL || p2 != NULL) {
            ListNode *node;
            if (p1 == NULL) {
                node = new ListNode(p2->val);
                p2 = p2->next;
            } else if (p2 == NULL) {
                node = new ListNode(p1->val);
                p1 = p1->next;
            } else {
                if (p1->val < p2->val) {
                    node = new ListNode(p1->val);
                    p1 = p1->next;
                } else {
                    node = new ListNode(p2->val);
                    p2 = p2->next;
                }
            }
            if (h == NULL) {
                h = node;
                p = h;
            } else {
                p->next = node;
                p = p->next;
            }
        }
        return h;
    }
};

int main() {
    Solution solu;
    ListNode* num1 = new ListNode(3);
    ListNode* num2 = new ListNode(7);
    ListNode* res = solu.mergeTwoLists(num1, num2);
    while (res != NULL) {
        std::cout<<res->val;
        res = res->next;
    }
}
