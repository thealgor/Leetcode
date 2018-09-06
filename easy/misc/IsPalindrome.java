package easy.misc;

class IsPalindrome {
    public boolean isPalindrome(int x) {

        if(x<0)
            return false;

        int num1 = x;

        int start = 0;
        while(x!=0){
            start = start*10+x%10;
            x=x/10;
        }

        return (num1==start)?true:false;
    }
}