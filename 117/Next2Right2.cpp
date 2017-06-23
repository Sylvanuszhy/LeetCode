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
        if (p) {
            if (p->left)
                h = p->left;
            else if (p->right)
                h = p->right;
        }
        while (h) {
            TreeLinkNode *q = NULL;
            h = NULL;
            while (p) {
                if (p->left) {
                    if (!q) {
                        q = p->left;
                        h = q;
                    } else {
                        q->next = p->left;
                        q = q->next;
                    }
                }
                if (p->right) {
                    if (!q) {
                        q = p->right;
                        h = q;
                    } else {
                        q->next = p->right;
                        q = q->next;
                    }
                }
                p = p->next;
            }
            p = h;
        }
    }
};
