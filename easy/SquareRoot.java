class SquareRoot {
    public int mySqrt(int x) {
        long lo =0, hi = x;
        if(x == 0 || x == 1)
            return x;

        int ans = -1;
        while(lo <= hi){
            long mid = lo + (hi -lo)/2;
            long midsquare = mid * mid;
            if(midsquare == (long)x)
                return (int)mid;
            else if(midsquare>(long)x){
                hi = mid - 1;
            }
            else{
                lo = mid + 1;
                ans = (int)mid;
            }

        }
        return ans;
    }

}