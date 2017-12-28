public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {

    TreeNode prev = null;
    TreeNode firstWrong = null, secondWrong = null;

    public void recoverTree(TreeNode root) {
        TreeNode curNode = root, prevNode = null;
        while (curNode != null) {
            if (curNode.left == null) {
                output(curNode);
                curNode = curNode.right;
            } else {
                prevNode = curNode.left;
                while (prevNode.right != null && prevNode.right != curNode)
                    prevNode = prevNode.right;
                if (prevNode.right == null) {
                    prevNode.right = curNode;
                    curNode = curNode.left;
                } else if (prevNode.right == curNode) {
                    prevNode.right = null;
                    output(curNode);
                    curNode = curNode.right;
                }
            }
        }
        int tmp = firstWrong.val;
        firstWrong.val = secondWrong.val;
        secondWrong.val = tmp;
    }

    public void output(TreeNode node) {
        if (prev != null && prev.val>node.val) {
            if (firstWrong == null)
                firstWrong = prev;
            secondWrong = node;
        }
        prev = node;
    }
}
