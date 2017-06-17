#include <iostream>

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<TreeNode*> generateTrees(int n) {
        if (n == 0)
            return {};
        else
            return generateBST(1, n);
    }
private:
    vector<TreeNode*> generateBST(int st, int ed) {
        vector<TreeNode*> subtree;
        if (st>ed)
            subtree.push_back(NULL);
        for (int k = st; k<=ed; k++) {
            vector<TreeNode*> left = generateBST(st, k-1);
            vector<TreeNode*> right = generateBST(k+1, ed);
            for (int i = 0; i<left.size(); i++)
                for (int j = 0; j<right.size(); j++) {
                    TreeNode *root = new TreeNode(k);
                    root->left = left[i];
                    root->right = right[j];
                    subtree.push_back(root);
                }
        }
        return subtree;
    }
};
