package DP;

class CountingBits {
    public int[] countBits(int num) {

        if(num==0)
            return new int[]{0};

        int[] dp = new int[num+1];

        dp[0] = 0;
        dp[1] = 1;

        for(int i=2;i<=num;i++)
            dp[i]=dp[i&(i-1)]+1;

        return dp;

    }
    //P(x) = P(x / 2) + (x \mod 2) P(x)=P(x/2)+(xmod2)
    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i >> 1] + (i & 1); // x / 2 is x >> 1 and x % 2 is x & 1
        return ans;
    }
}