class BestTimeToBuyAndSellStocks2 {
    public int maxProfit(int[] prices) {
        
        
        int result1 = betterSolution1(prices);
        int result2 = betterSolution2(prices);
        
        if(prices.length<=1)
            return 0;
        
        int m = prices.length;
        int[][] dp = new int[m][m];
        
        int profitFromPreviousRow = -1;
        for(int i=0;i<m;i++){
            for(int j=0;j<m;j++){
                if(i>j)
                    dp[i][j]=0;
                else if(i==0)
                    dp[i][j]=Math.max(0,prices[j]-prices[i]);
                else if(i==j){
                    profitFromPreviousRow = Math.max(0,Math.max(dp[i-1][j-1],dp[i-1][j]));
                    dp[i][j] = profitFromPreviousRow;
                }
                else{
                    dp[i][j]=Math.max(Math.max((profitFromPreviousRow+(prices[j]-prices[i])),(prices[j]-prices[i])),0); 
                    
                }
            }
        }
                


        
        return dp[m-1][m-1];
        
        return result2;
    }
    
    
    
    public int betterSolution1(int[] prices){
        
        if(prices.length<=1)
            return 0;
        
        int i = 0;
        int maxProfit = 0;
        int bottom = 0, top = 0;
        while(i<prices.length-1){
            while(i<prices.length-1&&prices[i]>=prices[i+1])
                i++;
            bottom = prices[i];
            
            while(i<prices.length-1 && prices[i]<=prices[i+1])
                i++;
            
            top = prices[i];
            
            maxProfit += top-bottom;
                
        }
        
        return maxProfit;
    }
    
    
    public int betterSolution2(int[] prices){
         if(prices.length<=1)
            return 0;
        int i = 0;
        int maxProfit = 0;
        
        while(i<prices.length-1){
            if(prices[i]<prices[i+1])
                maxProfit += prices[i+1]-prices[i];
            i++;
        }
        
        return maxProfit;
    }
    
    
    
    
}