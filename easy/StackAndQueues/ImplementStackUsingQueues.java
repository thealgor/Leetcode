class MyStack {

    Queue<Integer> q1, q2;
    /** Initialize your data structure here. */
    public MyStack() {
        q1= new LinkedList();
        q2 = new LinkedList();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if(q1.isEmpty()){
            q1.add(x);
            while(!q2.isEmpty()){
                q1.add(q2.poll());
            }
        }
        else{
            q2.add(x);
            while(!q1.isEmpty()){
                q2.add(q1.poll());
            }
        }

    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return q1.isEmpty()? q2.poll():q1.poll();
    }

    /** Get the top element. */
    public int top() {
        return q1.isEmpty()?q2.peek(): q1.peek();
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.isEmpty() && q2.isEmpty();
    }


    //can solve it using one queue
    public void push1(int x) {
        q1.add(x);
        int sz = q1.size();
        while (sz > 1) {
            q1.add(q1.remove());
            sz--;
        }
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */