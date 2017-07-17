#include <iostream>
#include <map>
using namespace std;

struct RandomListNode {
    int label;
    RandomListNode *next, *random;
    RandomListNode(int x) : label(x), next(NULL), random(NULL) {}
};

class Solution {
public:
    RandomListNode *copyRandomList(RandomListNode *head) {
        if (head == NULL)
            return NULL;
        map<RandomListNode*, RandomListNode*> dict;
        RandomListNode *h = new RandomListNode(head->label), *p = head->next, *q = h;
        dict.insert({head, h});
        while (p) {
            q->next = new RandomListNode(p->label);
            q = q->next;
            dict.insert({p, q});
            p = p->next;
        }
        p = head;
        q = h;
        while (p) {
            q->random = dict[p->random];
            p = p->next;
            q = q->next;
        }
        return h;
    }
};

int main() {
    Solution solu;
    solu.copyRandomList(NULL);
}
