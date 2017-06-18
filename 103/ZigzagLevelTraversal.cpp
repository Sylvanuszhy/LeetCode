#include <iostream>
#include <vector>
#include <deque>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    vector<vector<int>> zigzagLevelOrder(TreeNode* root) {
        vector<vector<int>> res;
        deque<TreeNode*> q;
        int k = 0, level = 0;
        if (root) {
            q.push_back(root);
            k = 1;
        }
        while (!q.empty()) {
            vector<int> order;
            level++;
            int cnt = 0;
            for (int i = 0; i<k; i++) {
                if (level%2 == 1) {
                    TreeNode *node = q.front();
                    order.push_back(node->val);
                    q.pop_front();
                    if (node->left) {
                        q.push_back(node->left);
                        cnt++;
                    }
                    if (node->right) {
                        q.push_back(node->right);
                        cnt++;
                    }
                } else {
                    TreeNode *node = q.back();
                    order.push_back(node->val);
                    q.pop_back();
                    if (node->right) {
                        q.push_front(node->right);
                        cnt++;
                    }
                    if (node->left) {
                        q.push_front(node->left);
                        cnt++;
                    }
                }
            }
            res.push_back(order);
            k = cnt;
        }
        return res;
    }
};
