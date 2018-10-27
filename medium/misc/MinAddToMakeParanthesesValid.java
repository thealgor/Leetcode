class Solution {
    public int minAddToMakeValid(String S) {

        if(S==null || S.length()==0)
            return 0;

        int left=0, right=0;

        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='(')
                left++;
            else if(S.charAt(i)==')'){
                if(left>0){
                    left--;
                }
                else
                    right++;
            }

        }
        return left+right;

    }
}