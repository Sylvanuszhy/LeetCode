#include <iostream>
#include <vector>
#include <queue>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<vector<int>> levelOrder(TreeNode* root) {
        vector<vector<int>> res;
        queue<TreeNode*> q;
        int k = 0;
        if (root) {
            q.push(root);
            k = 1;
        }
        while (!q.empty()) {
            vector<int> level;
            int cnt = 0;
            for (int i = 0; i<k; i++) {
                TreeNode *node = q.front();
                level.push_back(node->val);
                q.pop();
                if (node->left) {
                    q.push(node->left);
                    cnt++;
                }
                if (node->right) {
                    q.push(node->right);
                    cnt++;
                }
            }
            res.push_back(level);
            k = cnt;
        }
        return res;
    }
};
