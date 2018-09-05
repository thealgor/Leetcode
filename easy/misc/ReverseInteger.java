package misc;


class ReverseInteger {
    public int reverse(int x) {
        boolean isNegative = false;
        if(x<0)
            isNegative=true;

        x=Math.abs(x);
        int iResult = 0;
        long lResult = 0;

        while(x!=0){
            int rem = x%10;
            iResult = iResult*10 + rem;
            lResult = lResult*10+rem;
            x=x/10;
        }

        if(iResult!=lResult)
            return 0;

        if(isNegative)
            return -iResult;

        return iResult;
    }
}