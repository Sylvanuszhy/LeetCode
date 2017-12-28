import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {
        int n = s.length();
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i<n; i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(i);
            } else if (c == ')') {
                if (!stack.isEmpty() && s.charAt(stack.peek()) == '(') {
                    stack.pop();
                } else {
                    stack.push(i);
                }
            }
        }
        int m = n, maxLen = 0;
        while (!stack.isEmpty()) {
            int t = stack.pop();
            maxLen = Math.max(maxLen, m-t-1);
            m = t;
        }
        return Math.max(maxLen, m);
    }
}
