public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class BSTIterator {

    TreeNode node;
    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        node = root;
        stack = new Stack();
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        if (node == null && stack.empty())
            return false;
        else
            return true;
    }

    /** @return the next smallest number */
    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        int num = node.val;
        node = node.right;
        return num;
    }
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */