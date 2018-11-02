class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;

    /** initialize your data structure here. */
    public MinStack() {
        stack = new Stack<Integer>();
        minStack = new Stack();
    }

    public void push(int x) {
        stack.push(x);
        if(minStack.isEmpty() || minStack.peek()>=x){//missed minStack.isEmpty() condition
            minStack.push(x);
        }
        System.out.println(minStack);
    }

    public void pop() {
        if(stack.peek().equals(minStack.peek())){//missed out this too. For objects write equals.
            minStack.pop();
        }
        stack.pop();
        System.out.println("pop");
        System.out.println(minStack);
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */