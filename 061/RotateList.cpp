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
    ListNode* rotateRight(ListNode* head, int k) {
        int len = 0;
        ListNode *p = head, *q = NULL;
        while (p != NULL) {
            len++;
            q = p;
            p = p->next;
        }
        if (q != NULL)
            q->next = head;
        else
            return head;
        for (int i = 0; i<len-k%len; i++)
            q = q->next;
        p = q->next;
        q->next = NULL;
        return p;
    }
};
