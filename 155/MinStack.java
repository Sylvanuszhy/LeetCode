class MinStack {
    int minVal;
    Stack<Integer> stack;
    Stack<Integer> stackMin;

    /** initialize your data structure here. */
    public MinStack() {
        minVal = Integer.MAX_VALUE;
        stack = new Stack<Integer>();
        stackMin = new Stack<Integer>();
    }
    
    public void push(int x) {
        stack.push(x);
        if (x<=minVal) {
            stackMin.push(minVal);
            minVal = x;
        }
    }
    
    public void pop() {
        int val = stack.pop();
        if (val == minVal)
            minVal = stackMin.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minVal;
    }
}
