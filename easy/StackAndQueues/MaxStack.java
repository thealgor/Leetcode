

//(logN) for all operations except peek which is O(1)O(1), where NN is the number of operations performed. Most operations involving TreeMap are O(\log N)O(logN).
class MaxStack {

    DoubleLinkedList ll;
    TreeMap<Integer,List<Node>> map;
    /** initialize your data structure here. */
    public MaxStack() {
        ll = new DoubleLinkedList();
        map = new TreeMap();
    }

    public int top() {
        return ll.top();
    }

    public int peekMax() {
        return map.lastKey();//wasn't aware there was a method like this
    }

    public int popMax() {
        int max = peekMax();
        List<Node> list= map.get(max);
        Node n = list.remove(list.size()-1);
        if(list.isEmpty())
            map.remove(max);
        ll.unlink(n);
        return max;
    }

    public void push(int x) {
        Node n = new Node(x);
        ll.add(n);
        map.computeIfAbsent(x,k->new ArrayList<Node>()).add(n);
    }


    public int pop(){
        int x = ll.remove();
        List<Node> list = map.get(x);
        list.remove(list.size()-1);
        if(list.isEmpty())
            map.remove(x);
        return x;
    }

    public class DoubleLinkedList{
        Node head;
        Node tail;

        public DoubleLinkedList(){
            head = new Node(0);
            tail = new Node(0);
            head.next=tail;
            tail.prev=head;
        }

        public Node add(Node n){
            n.prev=tail.prev;
            n.next=tail;
            tail.prev.next=n;
            tail.prev=n;
            return n;
        }

        public int remove(){
            return unlink(tail.prev).val;
        }


        public int top(){
            return tail.prev.val;
        }

        public Node unlink(Node n){
            n.prev.next=n.next;
            n.next.prev=n.prev;
            return n;
        }

    }

    public class Node{
        Node prev, next;
        int val;
        public Node(int val){
            this.val=val;
        }

    }


}


// push(x) -- O(lgn)
// pop() -- O(n) because removing specific node from pq takes O(n) time
// top() -- O(1)
// peekMax() O(1)
// popMax() O(n) because removing one item from stack takes O(n) time



class MaxStackPQ{
    Stack<Integer> s;
    PriorityQueue<Integer> pq;
    /** initialize your data structure here. */
    public MaxStackPQ() {
        s = new Stack<Integer>();
        pq = new PriorityQueue<Integer>(10000, Collections.reverseOrder());
    }

    public void push(int x) {
        s.push(x);
        pq.offer(x);
    }

    public int pop() {
        int pop = s.pop();
        pq.remove(pop);
        return pop;
    }

    public int top() {
        return s.peek();
    }

    public int peekMax() {
        return pq.peek();
    }

    public int popMax() {
        int max = pq.poll();
        Stack<Integer> sp = new Stack<Integer>();
        while (!s.isEmpty()) {
            if (s.peek() != max) {
                sp.push(s.pop());
            } else {
                s.pop();
                break;
            }
        }
        while (!sp.isEmpty()) {
            s.push(sp.pop());
        }
        return max;
    }
}



//Time Complexity: O(N)O(N) for the popMax operation, and O(1)O(1) for the other operations, where NN is the number of operations performed.
class MaxStack1 {

    Stack<Integer> stack;
    Stack<Integer> maxStack;

    /** initialize your data structure here. */
    public MaxStack1() {
        stack = new Stack();
        maxStack = new Stack();
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        Stack<Integer> temp = new Stack();
        int result = -1;
        while(!stack.peek().equals(maxStack.peek())){
            temp.push(stack.pop());
            maxStack.pop();
        }

        if(stack.peek().equals(maxStack.peek())) result = pop();

        while(!temp.isEmpty()) push(temp.pop());

        return result;
    }

    public void push(int x) {
        stack.push(x);
        if(maxStack.isEmpty()||maxStack.peek()<x)
            maxStack.push(x);
        else
            maxStack.push(maxStack.peek());
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */