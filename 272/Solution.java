import java.util.ArrayList;
import java.util.Stack;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Stack<Integer> pred = new Stack<Integer>();
        Stack<Integer> succ = new Stack<Integer>();
        traversal(root, target, pred, false);
        traversal(root, target, succ, true);

        ArrayList<Integer> res = new ArrayList<Integer>();
        for (int i = 0; i<k; i++) {
            if (pred.isEmpty()) {
                res.add(succ.pop());
                continue;
            }
            if (succ.isEmpty()) {
                res.add(pred.pop());
                continue;
            }
            if (target-pred.peek() < succ.peek()-target)
                res.add(pred.pop());
            else
                res.add(succ.pop());
        }
        return res;
    }

    public void traversal(TreeNode node, double target, Stack<Integer> stack, boolean reverse) {
        if (node == null)
            return;
        if (!reverse)
            traversal(node.left, target, stack, reverse);
        else
            traversal(node.right, target, stack, reverse);
        if (!reverse && node.val>target || reverse && node.val<=target)
            return;
        else
            stack.push(node.val);
        if (!reverse)
            traversal(node.right, target, stack, reverse);
        else
            traversal(node.left, target, stack, reverse);
    }
}
