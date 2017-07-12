#include <iostream>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    int sumNumbers(TreeNode* root) {
        if (root)
            dfs(root, 0);
        return this->s;
    }
private:
    int s = 0;

    void dfs(TreeNode *node, int num) {
        if (node->left == NULL && node->right == NULL) {
            s += num*10 + node->val;
        } else {
            if (node->left)
                dfs(node->left, num*10 + node->val);
            if (node->right)
                dfs(node->right, num*10 + node->val);
        }
    }
};
