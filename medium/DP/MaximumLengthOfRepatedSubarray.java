class Solution {
    public int findLength(int[] A, int[] B) {
        if(A==null || B==null)
            return 0;
        int m = A.length, n=B.length;
        int[][] dp  = new int[m+1][n+1];
        int max=0;
        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(A[i-1]==B[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                    max=Math.max(dp[i][j],max);
                }
            }
        }
        return max;
    }
}