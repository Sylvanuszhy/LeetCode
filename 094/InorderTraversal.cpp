#include <iostream>
#include <vector>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<int> inorderTraversal(TreeNode* root) {
        vector<int> res;
        vector<TreeNode*> stack;
        TreeNode *node = root;
        if (root)
            stack.push_back(root);
        else
            return res;
        while (true) {
            if (node->left) {
                node = node->left;
                stack.push_back(node);
            } else {
                do {
                    if (stack.empty())
                        return res;
                    node = stack.back();
                    stack.pop_back();
                    res.push_back(node->val);
                } while (!node->right);
                node = node->right;
                stack.push_back(node);
            }
        }
    }
};
