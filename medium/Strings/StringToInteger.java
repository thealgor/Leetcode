class Solution {
    public int myAtoi(String str) {

        if(str.length() == 0) return 0;
        //look for empty space
        int index=0;
        while(index<str.length() && str.charAt(index)==' ')
            index++;

        if(index>=str.length()) return 0;

        int sign=1;
        //look for sign
        if(str.charAt(index)=='+'||str.charAt(index)=='-'){
            sign = str.charAt(index)=='+'?1:-1;
            index++;
        }

        int total = 0;
        while(index<str.length()){
            int digit = str.charAt(index)-'0';
            if(digit<0 || digit>9) break;

            if(Integer.MAX_VALUE/10<total || (Integer.MAX_VALUE/10==total && Integer.MAX_VALUE%10<digit))
                return sign==1?Integer.MAX_VALUE:Integer.MIN_VALUE;


            total=total*10+digit;

            index++;
        }

        return total*sign;


    }
}