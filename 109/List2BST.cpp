#include <iostream>

struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    TreeNode* sortedListToBST(ListNode* head) {
        this->li = head;
        ListNode *p = head;
        int m = 0;
        while (p) {
            m++;
            p = p->next;
        }
        return buildBST(m);
    }
private:
    ListNode *li;

    TreeNode *buildBST(int n) {
        if (n == 0)
            return NULL;
        TreeNode *root = new TreeNode(0);
        root->left = buildBST(n/2);
        root->val = this->li->val;
        this->li = this->li->next;
        root->right = buildBST(n-n/2-1);
        return root;
    }
};
