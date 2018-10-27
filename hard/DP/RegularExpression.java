//https://www.youtube.com/watch?v=l3hda49XcDE


/*
*
1, If p.charAt(j) == s.charAt(i) :  dp[i][j] = dp[i-1][j-1];
2, If p.charAt(j) == '.' : dp[i][j] = dp[i-1][j-1];
3, If p.charAt(j) == '*':
   here are two sub conditions:
               1   if p.charAt(j-1) != s.charAt(i) : dp[i][j] = dp[i][j-2]  //in this case, a* only counts as empty
               2   if p.charAt(i-1) == s.charAt(i) or p.charAt(i-1) == '.':
                              dp[i][j] = dp[i-1][j]    //in this case, a* counts as multiple a
                           or dp[i][j] = dp[i][j-1]   // in this case, a* counts as single a
                           or dp[i][j] = dp[i][j-2]   // in this case, a* counts as empty
*/




class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m+1][n+1];

        dp[0][0]=true;

        //Deals with patterns like a* or a*b* or a*b*c* - 0th row can be true
        for(int i=1;i<dp[0].length;i++){
            if(p.charAt(i-1)=='*')
                dp[0][i]=dp[0][i-2];
        }

        for(int i=1;i<m+1;i++){
            for(int j=1;j<n+1;j++){

                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.'){
                    dp[i][j]=dp[i-1][j-1];
                }

                //if it is * look two characters behind and see if its a match or else remove the current letter on S and check if its a match.
                if(p.charAt(j-1)=='*'){
                    dp[i][j]=dp[i][j-2]; //can be zero occurancs as well. example ab abc* is a match. zero occurances of c.
                    if(s.charAt(i-1)==p.charAt(j-2) || p.charAt(j-2)=='.'){
                        dp[i][j]=dp[i][j] ||dp[i-1][j] ;  //check if xa* is regular expression of xa . || remove a* and see valid - dp[i][j-2] and now remove a and check x and xa* are valid check above.
                    }


                }



            }
        }

        return dp[m][n];

    }
}