#include <iostream>
#include <vector>
#include <map>
using namespace std;

struct TreeNode {
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int x) : val(x), left(NULL), right(NULL) {}
};

class Solution {
public:
    TreeNode* buildTree(vector<int>& inorder, vector<int>& postorder) {
        this->inorder = inorder;
        this->postorder = postorder;
        for (int i = 0; i<inorder.size(); i++)
            this->d[inorder[i]] = i;
        return constructTree(postorder.size()-1, 0, inorder.size()-1);
    }
private:
    vector<int> inorder;
    vector<int> postorder;
    map<int, int> d;

    TreeNode* constructTree(int pos, int st, int ed) {
        if (st>ed)
            return NULL;
        int val = this->postorder[pos];
        TreeNode *root = new TreeNode(val);
        int idx = d[val];
        root->left = constructTree(pos-(ed-idx)-1, st, idx-1);
        root->right = constructTree(pos-1, idx+1, ed);
        return root;
    }
};
