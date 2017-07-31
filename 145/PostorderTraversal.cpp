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
    vector<int> postorderTraversal(TreeNode* root) {
        vector<int> res;
        stack<TreeNode *> s;
        TreeNode *node = root;
        while (!s.empty() || node) {
            if (node) {
                s.push(node->left);
                res.push_back(node->val);
                node = node->right;
            } else {
                node = s.top();
                s.pop();
            }
        }
        int i = 0, j = res.size()-1;
        while (i<j) {
            int tmp = res[i];
            res[i] = res[j];
            res[j] = tmp;
            i++, j--;
        }
        return res;
    }
};
