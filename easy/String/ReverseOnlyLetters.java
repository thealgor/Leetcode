class Solution {
    public String reverseOnlyLetters(String S) {
        if(S==null || S.length()<1)
            return S;
        char[] cs = S.toCharArray();
        int i=0, j=S.length()-1;

        while(i<j){
            while(i<j && !isLetter(cs[i]))
                i++;
            while(i<j && !isLetter(cs[j]))
                j--;

            if(i>=j) break;

            swap(cs,i,j);
            i++;
            j--;

        }
        return new String(cs);

    }


    public void swap(char[] cs, int i, int j){
        char temp = cs[i];
        cs[i]=cs[j];
        cs[j]=temp;
    }

    public boolean isLetter(char c){
        boolean isLet = (c>='A'&& c<='Z') || (c>='a'&& c<='z');
        return isLet;
    }
}