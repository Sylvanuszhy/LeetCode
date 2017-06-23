#include <iostream>
using namespace std;

struct TreeLinkNode {
 int val;
 TreeLinkNode *left, *right, *next;
 TreeLinkNode(int x) : val(x), left(NULL), right(NULL), next(NULL) {}
};

class Solution {
public:
    void connect(TreeLinkNode *root) {
        TreeLinkNode *p = root, *h = NULL;
        if (p)
            h = p->left;
        while (h) {
            h->next = p->right;
            TreeLinkNode *q = p->right;
            p = p->next;
            while (p) {
                q->next = p->left;
                p->left->next = p->right;
                q = p->right;
                p = p->next;
            }
            p = h;
            h = h->left;
        }
    }
};
