class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if(prices.length<1)
            return 0;

        int m = prices.length;
        int[] dp = new int[m];

        for(int i=0;i<m;i++){
            if(i==0)
                dp[i]=prices[i];
            else {
                dp[i]=Math.min(dp[i-1],prices[i]);
            }
        }

        int max = Integer.MIN_VALUE;

        for(int i=0;i<m;i++){
            max = Math.max(max,(prices[i]-dp[i]));
        }
        return max;

    }
}