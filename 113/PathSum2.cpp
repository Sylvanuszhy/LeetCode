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
    vector<vector<int>> pathSum(TreeNode* root, int sum) {
        this->sum = sum;
        if (root) {
            this->path.push_back(root->val);
            dfs(root, root->val);
            this->path.pop_back();
        }
        return this->res;
    }
private:
    int sum;
    vector<int> path;
    vector<vector<int>> res;
    
    void dfs(TreeNode *root, int s) {
        if (!root->left && !root->right) {
            if (s == this->sum)
                this->res.push_back(this->path);
        } else {
            if (root->left) {
                this->path.push_back(root->left->val);
                dfs(root->left, s+root->left->val);
                this->path.pop_back();
            }
            if (root->right) {
                this->path.push_back(root->right->val);
                dfs(root->right, s+root->right->val);
                this->path.pop_back();
            }
        }
    }
};
