#include <iostream>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isSymmetric(TreeNode* root) {
        if (root == NULL)
            return true;
        else
            return checkSymmetry(root->left, root->right);
    }
private:
    bool checkSymmetry(TreeNode *leftTree, TreeNode *rightTree) {
        if (leftTree == NULL && rightTree == NULL)
            return true;
        else if (leftTree && rightTree && leftTree->val == rightTree->val)
            return checkSymmetry(leftTree->left, rightTree->right) && checkSymmetry(leftTree->right, rightTree->left);
        else
            return false;
    }
};
