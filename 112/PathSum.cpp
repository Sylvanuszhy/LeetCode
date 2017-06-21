#include <iostream>

class Solution {
public:
    bool hasPathSum(TreeNode* root, int sum) {
        this->sum = sum;
        if (root)
            dfs(root, root->val);
        return this->flag;
    }
private:
    int sum;
    bool flag = false;
    
    void dfs(TreeNode *root, int s) {
        if (!root->left && !root->right || this->flag) {
            if (s == this->sum)
                this->flag = true;
            if (this->flag)
                return;
        } else {
            if (root->left)
                dfs(root->left, s+root->left->val);
            if (root->right)
                dfs(root->right, s+root->right->val);
        }
    }
};
