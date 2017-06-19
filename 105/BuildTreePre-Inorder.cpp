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
    TreeNode* buildTree(vector<int>& preorder, vector<int>& inorder) {
        map<int, int> d;
        for (int i = 0; i<inorder.size(); i++)
            d[inorder[i]] = i;
        TreeNode *root = NULL;
        if (preorder.size()>0) {
            root = new TreeNode(preorder[0]);
        }
        for (int i = 1; i<preorder.size(); i++) {
            int ch = d[preorder[i]];
            TreeNode *p = root;
            while (true) {
                int fa = d[p->val];
                if (ch<fa) {
                    if (p->left) {
                        p = p->left;
                    } else {
                        TreeNode *leaf = new TreeNode(preorder[i]);
                        p->left = leaf;
                        break;
                    }
                } else {
                    if (p->right) {
                        p = p->right;
                    } else {
                        TreeNode *leaf = new TreeNode(preorder[i]);
                        p->right = leaf;
                        break;
                    }
                }
            }
        }
        return root;
    }
};
