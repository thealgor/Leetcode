
class FreqStack {

    Map<Integer,Integer> freq;
    Map<Integer,Stack> group;
    int maxFreq;


    public FreqStack() {
        freq = new HashMap();
        group = new HashMap();
        maxFreq=Integer.MIN_VALUE;
    }

    public void push(int x) {
        freq.put(x,freq.getOrDefault(x,0)+1);
        group.computeIfAbsent(freq.get(x),k -> new Stack<Integer>()).push(x);
        maxFreq = Math.max(maxFreq,freq.get(x));
    }

    public int pop() {
        Stack<Integer> stack = group.get(maxFreq);
        int result = stack.pop();
        freq.put(result,freq.get(result)-1);
        if(stack.size()==0)
            maxFreq--;
        return result;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 */