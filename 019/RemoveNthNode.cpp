#include <iostream>
#include <vector>
using namespace std;

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        vector<ListNode*> nodes(n+1, NULL);
        int k = 0;
        ListNode *p = head;
        while (p != NULL) {
            nodes[k] = p;
            p = p->next;
            k = (k+1)%(n+1);
        }
        ListNode *q = nodes[(k+1)%(n+1)];
        if (nodes[k] != NULL) {
            nodes[k]->next = q->next;
            return head;
        } else {
            return q->next;
        }
    }
};

int main() {
    Solution solu;
    ListNode* list = new ListNode(3);
    int n = 1;
    ListNode* res = solu.removeNthFromEnd(list, n);
    while (res != NULL) {
        cout<<res->val;
        res = res->next;
    }
}
