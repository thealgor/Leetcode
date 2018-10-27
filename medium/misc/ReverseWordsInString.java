class Solution {
    public void reverseWords(char[] str) {
        if(str==null || str.length==0)
            return;
        char[] cs = str;
        reverse(cs,0, cs.length-1);
        int start = 0, end =0;

        for(int i=0;i<cs.length;i++){
            if(cs[i]!=' '){
                cs[end++]=cs[i];
            }
            else if(i>0 && cs[i-1]!=' '){
                reverse(cs,start,end-1);
                cs[end++]=' ';
                start=end;
            }
        }

        //reverse the last word
        reverse(cs, start,cs.length-1);
        // here's an ugly return just because we need to return Java's String
        // also as there could be spaces at the end of original string
        // we need to consider redundant space we have put there before
        // return new String(cs, 0, end > 0 && cs[end-1] == ' ' ? end-1 : end);
    }

    public void reverse(char[] cs, int start, int end){
        while(start<end){
            char temp = cs[start];
            cs[start]=cs[end];
            cs[end]=temp;
            start++;
            end--;
        }
    }
}