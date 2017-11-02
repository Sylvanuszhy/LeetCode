import java.util.Stack;

class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack stack = new Stack<Integer>();
        int res = 0;
        int i = 0;
        while (i<=heights.length) {
            int height = i<heights.length ? heights[i] : 0;
            if (stack.empty() || height>=heights[(int)stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int k = (int)stack.pop();
                int left = stack.empty() ? -1 : (int)stack.peek();
                int right = i;
                int a = (right-left-1)*heights[k];
                res = Math.max(res, a);
            }
        }
        return res;
    }
}
