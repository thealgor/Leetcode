class Solution {
    public boolean isSubsequence(String s, String t) {
        char[] t1 = s.toCharArray();
        char[] s1= t.toCharArray();

        int i=0, j=0;

        while(i<s1.length && j<t1.length){
            if(s1[i]==t1[j]){
                i++;
                j++;
            }
            else
                i++;
        }


        //  System.out.println(j);

        if(j==s.length())
            return true;
        return false;
    }
}