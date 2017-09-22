public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public int maxPath;

    public int maxPathSum(TreeNode root) {
        maxPath = Integer.MIN_VALUE;
        maxSum(root);
        return maxPath;
    }

    public int maxSum(TreeNode node) {
        if (node == null)
            return 0;
        int left = Math.max(maxSum(node.left), 0);
        int right = Math.max(maxSum(node.right), 0);
        maxPath = Math.max(maxPath, left+node.val+right);
        return node.val+Math.max(left, right);
    }
}
