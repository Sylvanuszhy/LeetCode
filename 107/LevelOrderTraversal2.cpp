#include <iostream>
#include <vector>
#include <queue>
#include <stack>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<vector<int>> levelOrderBottom(TreeNode* root) {
        stack<vector<int>> level;
        queue<TreeNode*> q;
        int k = 0;
        if (root) {
            q.push(root);
            k = 1;
        }
        while (!q.empty()) {
            vector<int> order;
            int cnt = 0;
            for (int i = 0; i<k; i++) {
                TreeNode *node = q.front();
                order.push_back(node->val);
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
            level.push(order);
            k = cnt;
        }
        vector<vector<int>> res;
        while (!level.empty()) {
            res.push_back(level.top());
            level.pop();
        }
        return res;
    }
};
