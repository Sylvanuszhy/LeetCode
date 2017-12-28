public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public int len;

    public int longestUnivaluePath(TreeNode root) {
        len = 0;
        if (root != null)
            univalue(root);
        return len;
    }

    public int univalue(TreeNode node) {
        int left = 0, right = 0;
        if (node.left != null) {
            left = univalue(node.left);
            if (node.val == node.left.val)
                left += 1;
            else
                left = 0;
        }
        if (node.right != null) {
            right = univalue(node.right);
            if (node.val == node.right.val)
                right += 1;
            else
                right = 0;
        }
        len = Math.max(len, left+right);
        return Math.max(left, right);
    }
}
