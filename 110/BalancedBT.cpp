#include <iostream>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    bool isBalanced(TreeNode* root) {
        this->flag = true;
        depth(root);
        return this->flag;
    }
private:
    bool flag;

    int depth(TreeNode *root) {
        if (!root)
            return 0;
        int left = depth(root->left);
        int right = depth(root->right);
        if (abs(left-right)>1)
            this->flag = false;
        return max(left, right)+1;
    }
};
