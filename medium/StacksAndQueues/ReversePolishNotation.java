class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> numbers = new Stack<Integer>();

        for(String t: tokens){
            if(t.equals("*")||t.equals("/")||t.equals("-")||t.equals("+")){
                int n2 = numbers.pop();
                int n1 = numbers.pop();

                int result = 1;
                if(t.equals("*")){
                    result = n1*n2;
                }
                else if(t.equals("/")){
                    result = n1/n2;
                }
                else if(t.equals("+")){
                    result = n1+n2;
                }
                else if(t.equals("-")){
                    result = n1-n2;
                }
                numbers.push(result);
            }
            else{
                numbers.push(Integer.parseInt(t));
            }

        }

        return numbers.peek();


    }
}