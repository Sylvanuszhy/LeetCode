import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        int k = 0;
        if (root != null) {
            queue.add(root);
            k = 1;
        }
        while (!queue.isEmpty()) {
            TreeNode node = new TreeNode(0);
            int cnt = 0;
            for (int i = 0; i<k; i++) {
                node = queue.remove();
                if (node.left != null) {
                    queue.add(node.left);
                    cnt++;
                }
                if (node.right != null) {
                    queue.add(node.right);
                    cnt++;
                }
            }
            list.add(node.val);
            k = cnt;
        }
        return list;
    }
}
