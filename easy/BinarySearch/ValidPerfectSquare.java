/**
 * Missed out on the long case. It was failing for 808201. After changing lo and hi to long, it worked.
 * when num=1 failed
 * time out exception when 2147483647. changing hi=num/2 helped resolve it.
 */



class Solution {
    public boolean isPerfectSquare(int num) {

        if(num==1||num==0)
            return true;

        long lo=0, hi=num/2;

        long nums = (long)num;

        while(lo<=hi){
            long mid = lo + (hi-lo)/2;
            long midsquare = mid*mid;

            if(midsquare<nums){
                lo=mid+1;
            }
            else if(midsquare>nums)
                hi=mid-1;
            else
                return true;
        }
        return false;
    }
}