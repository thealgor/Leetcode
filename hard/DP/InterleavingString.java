class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        int m = s1.length(), n=s2.length(), l = s3.length();
        if(m+n!=l)
            return false;
        boolean[][] dp = new boolean[m+1][n+1];
        for(int i=0;i<m+1;i++){
            for(int j=0;j<n+1;j++){
                int k = i+j-1;
                if(i==0 && j==0)
                    dp[i][j]=true;
                else if(i==0 ){
                    if(s3.charAt(k)==s2.charAt(j-1))
                        dp[i][j]=dp[i][j-1];
                }
                else if(j==0){
                    if( s3.charAt(k)==s1.charAt(i-1)){
                       
                        dp[i][j]=dp[i-1][j];
                    }
                }
                else{
                    dp[i][j]=((s3.charAt(k)==s2.charAt(j-1)?dp[i][j-1]:false) || (s3.charAt(k)==s1.charAt(i-1)?dp[i-1][j]:false));
      
                }
                
            }
        }
        
        for(int i=0;i<dp.length;i++)
            System.out.println(Arrays.toString(dp[i]));
        
        return dp[m][n];
    }
}