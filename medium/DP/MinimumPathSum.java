class MinimumPathSum {
    public int minPathSum(int[][] grid) {

        if(grid.length<1)
            return -1;

        if(grid[0]==null)
            return -1;

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0)
                    dp[i][j]=grid[i][j];
                else if(i==0)
                    dp[i][j]=dp[i][j-1]+grid[i][j];
                else if(j==0)
                    dp[i][j]=dp[i-1][j]+grid[i][j];
                else{
                    dp[i][j]=Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
                }
            }
        }

        return dp[m-1][n-1];


    }
    
    public int minCost(int [][]cost,int m,int n){
        
        int temp[][] = new int[m+1][n+1];
        int sum = 0;
        for(int i=0; i <= n; i++){
            temp[0][i] = sum + cost[0][i];
            sum = temp[0][i];
        }
        sum = 0;
        for(int i=0; i <= m; i++){
            temp[i][0] = sum + cost[i][0];
            sum = temp[i][0];
        }
        
        for(int i=1; i <= m; i++){
            for(int j=1; j <= n; j++){
                temp[i][j] = cost[i][j] + min(temp[i-1][j-1], temp[i-1][j],temp[i][j-1]);
            }
        }
        return temp[m][n];
    }
}
