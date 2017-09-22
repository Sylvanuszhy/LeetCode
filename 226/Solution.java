public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return root;
        TreeNode rightT = invertTree(root.left);
        TreeNode leftT = invertTree(root.right);
        root.left = leftT;
        root.right = rightT;
        return root;
    }
}
