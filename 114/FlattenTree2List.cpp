#include <iostream>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    void flatten(TreeNode* root) {
        flattenTree(root);
    }
private:
    TreeNode *flattenTree(TreeNode *root) {
        if (!root)
            return NULL;
        TreeNode *left = flattenTree(root->left);
        TreeNode *right = flattenTree(root->right);
        if (left) {
            left->right = root->right;
            root->right = root->left;
            root->left = NULL;
        }
        if (right)
            return right;
        else if (left)
            return left;
        else
            return root;
    }
};
