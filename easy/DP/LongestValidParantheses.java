class Solution {

    //dp
    public int longestValidParentheses(String s) {
        int n=s.length();
        int[] dp = new int[n];
        int max=0;
        for(int i=1;i<n;i++){
            if(s.charAt(i)==')'){
                if(s.charAt(i-1)=='(')
                    dp[i]=(i>=2?dp[i-2]:0)+2;
                else if(i-dp[i-1]-1>=0 && s.charAt(i-dp[i-1]-1)=='('){
                    dp[i]= dp[i-1]+(i-dp[i-1]-2>=0?dp[i-dp[i-1]-2]:0)+2;
                }
                max=Math.max(dp[i],max);
            }
        }
        return max;


    }



    //O(n) and O(1) solution
    public int longestValidParenthesesTwoPointer(String s) {
        int left=0,right=0,max=0;
        //left to right;
        int i=0;
        while(i<s.length()){
            if(s.charAt(i)=='(') left++;
            if(s.charAt(i)==')') right++;
            if(left==right) max=Math.max(left+right,max);
            if(right>left) left=right=0;
            i++;
        }

        //right to left
        i=s.length()-1;
        left=0;right=0;
        while(i>=0){
            if(s.charAt(i)=='(') left++;
            if(s.charAt(i)==')') right++;
            if(left==right) max=Math.max(left+right,max);
            if(left>right) left=right=0;
            i--;
        }

        return max;

    }


    public int longestValidParenthesesUsingStack(String s) {
        if(s==null|| s.length()<1) return 0;
        Stack<Integer> stack = new Stack();
        int index=0, max=0;
        stack.push(-1);
        for(int i=0;i<s.length();i++){

            if(s.charAt(i)==')' ){
                stack.pop();
                if(stack.isEmpty()){ //reset the position once invalid
                    stack.push(i);
                    continue;
                }
                else{
                    max=Math.max(i-stack.peek(),max);
                }
            }
            else if(s.charAt(i)=='(')
                stack.push(i);
        }
        return max;

    }
}