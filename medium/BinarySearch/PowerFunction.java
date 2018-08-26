/**
 *  failed for this use case:
 x 2.00000
 n -2147483648
 *
 */


class Solution {
    public double myPow(double x, int n) {
        long N = (long)n;
        if(n<0){
            x=1/x;
            N=-N;
        }

        return fastPowIterative(x, N);
    }
    public double fastPow(double x, long N){

        if(N==0)
            return 1;
        if(N==1)
            return x;

        double result = fastPow(x,N/2);

        if(N%2==0)
            return result*result;
        else
            return result*result*x;
    }


    public double fastPowIterative(double x, long N){
        if(N==0)
            return 1;
        if(N==1)
            return x;
        double ans = 1;
        double product = x;
        for(long i=N;i>0;i/=2){
            if(i%2==1){
                ans *= product;
            }
            product = product*product;
        }
        return ans;
    }

}