class Solution {
    public String parseTernary(String expression) {
        char[] exp = expression.toCharArray();
        return dfs(0,exp.length-1,exp)+"";
    }

    public char dfs(int start, int end, char[] exp){

        if(start==end)
            return exp[start];


        int count = 0, i=start;
        for(;i<=end;i++){
            if(exp[i]=='?')
                count++;
            else if(exp[i]==':'){
                count--;
                if(count==0) break;
            }

        }
        return exp[start]=='T'?dfs(start+2,i-1,exp):dfs(i+1,end,exp);


    }


}