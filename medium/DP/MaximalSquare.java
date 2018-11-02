class Solution {
    //O(n2) space
    public int maximalSquare1(char[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] dp = new int[m+1][n+1];
        int max=0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(matrix[i-1][j-1]=='1'){
                    dp[i][j]=Math.min(Math.min(dp[i-1][j],dp[i][j-1]),dp[i-1][j-1])+1;
                    max=Math.max(max,dp[i][j]);
                }
            }
        }
        return max*max;

    }
    //O(n) space - In the previous approach for calculating dp of ith row we are using only the previous element and the (i−1)th row. Therefore, we don't need 2D dp matrix as 1D dp array will be sufficient for this.


    public int maximalSquare(char[][] matrix) {
        if(matrix==null || matrix.length==0)
            return 0;
        int m = matrix.length, n = matrix[0].length;
        int max=0,prev=0;
        int[] dp = new int[n+1];

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                int temp=dp[j];
                if(matrix[i-1][j-1]=='1'){
                    dp[j]=Math.min(Math.min(dp[j-1],dp[j]),prev)+1;
                    max=Math.max(dp[j],max);
                }
                else
                    dp[j]=0;

                prev=temp;
            }

        }
        return max*max;
    }



}