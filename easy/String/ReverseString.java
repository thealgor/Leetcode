class Solution1 {
    public String reverseString(String s) {
        if(s==null) return s;
        int n=s.length();
        char[] cs = s.toCharArray();
        int j=0, k=n-1;
        for(int i=0;i<n/2;i++){
            char temp=cs[j];
            cs[j]=cs[k];
            cs[k]=temp;
            j++;
            k--;
        }
        return new String(cs);
    }
}

class Solution {
    public String reverseString(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            word[i] = (char) (word[i] ^ word[j]);
            word[j] = (char) (word[i] ^ word[j]);
            word[i] = (char) (word[i] ^ word[j]);
            i++;
            j--;
        }
        return new String(word);
    }
}