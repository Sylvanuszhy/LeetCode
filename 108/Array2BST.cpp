#include <iostream>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    TreeNode* sortedArrayToBST(vector<int>& nums) {
        this->nums = nums;
        return this->array2BST(0, nums.size()-1);
    }
private:
    vector<int> nums;

    TreeNode* array2BST(int st, int ed) {
        if (st>ed)
            return NULL;
        int k = (st+ed)/2;
        TreeNode *root = new TreeNode(this->nums[k]);
        root->left = array2BST(st, k-1);
        root->right = array2BST(k+1, ed);
        return root;
    }
};
