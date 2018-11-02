class Solution {
    public int[] dailyTemperatures(int[] T) {
        Stack<Integer> stack = new Stack();
        int[] r = new int[T.length];
        Arrays.fill(r,-1);
        stack.add(T.length-1);
        r[T.length-1]=0;
        for(int i=T.length-1;i>=0;i--){
            int peek = stack.peek();
            if(!stack.isEmpty() && T[peek]>T[i]){
                r[i]=1;
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && T[peek]<=T[i]){
                    stack.pop();
                    if(!stack.isEmpty())
                        peek=stack.peek();
                }
                //either empty or found element greater
                if(stack.isEmpty())
                    r[i]=0;
                else {
                    r[i]=peek-i;
                }


            }
            stack.push(i);
        }
        return r;
    }

}
