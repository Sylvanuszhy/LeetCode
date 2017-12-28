public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public int minVal, maxVal;

    public int closestValue(TreeNode root, double target) {
        minVal = root.val;
        maxVal = root.val;
        search(root, target);
        if (Math.abs(target-minVal) < Math.abs(maxVal-target))
            return minVal;
        else
            return maxVal;
    }

    public void search(TreeNode node, double target) {
        if (node == null)
            return;
        if (node.val<target) {
            minVal = node.val;
            search(node.right, target);
        } else {
            maxVal = node.val;
            search(node.left, target);
        }
    }
}
