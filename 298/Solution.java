public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    public int longest;

    public int longestConsecutive(TreeNode root) {
        longest = 0;
        if (root != null)
            findConsecutive(root);
        return longest;
    }

    public int findConsecutive(TreeNode node) {
        int curLen = 1;
        if (node.left != null) {
            int leftLen = findConsecutive(node.left);
            if (node.left.val == node.val+1)
                leftLen++;
            else
                leftLen = 1;
            curLen = Math.max(curLen, leftLen);
        }
        if (node.right != null) {
            int rightLen = findConsecutive(node.right);
            if (node.right.val == node.val+1)
                rightLen++;
            else
                rightLen = 1;
            curLen = Math.max(curLen, rightLen);
        }
        longest = Math.max(longest, curLen);
        return curLen;
    }
}
