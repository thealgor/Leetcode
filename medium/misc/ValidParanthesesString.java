class Solution {
    public boolean checkValidString(String s) {
        int low=0, high=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                low++;
                high++;
            }

            else if(s.charAt(i)==')'){
                if(low>0)
                    low--;
                high--;

                if(high<0)
                    return false;

            }
            else{
                if(low>0)
                    low--;
                high++;
            }

        }

        return low==0;
    }

}