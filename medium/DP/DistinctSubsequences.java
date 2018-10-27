class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m+1][n+1];

        if(s==null || s.length()<1 )
            return 0;
        //empty string
        for(int i=0;i<m+1;i++) //if t is empty string you have one solution -> delete all the elements.
            dp[i][0]=1;


        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){
                if(s.charAt(i-1)==t.charAt(j-1)){
                    /*
                    1) We don't match those two characters, which means that it still has original number of distinct subsequences, so dp[i][j] = dp[i-1][j].
2) We match those two characters, in this way. dp[i][j] = dp[i-1][j-1];
Thus, including both two case, dp[i][j] = dp[i-1][j] + dp[i-1][j-1]
*/

                    dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=dp[i-1][j]; //delete character in 's' meaning get the previous count without the current char in S.
                }
            }
        }

        return dp[m][n];
    }
}