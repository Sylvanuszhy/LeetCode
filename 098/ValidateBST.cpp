#include <iostream>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isValidBST(TreeNode* root) {
        return this->isValidBST(root, LONG_MIN, LONG_MAX);
    }
private:
    bool isValidBST(TreeNode *root, long minVal, long maxVal) {
        if (root == NULL) {
            return true;
        } else {
            if (minVal<root->val && root->val<maxVal)
                return isValidBST(root->left, minVal, root->val) && isValidBST(root->right, root->val, maxVal);
            else
                return false;
        }
    }
};
