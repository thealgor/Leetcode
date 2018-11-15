public class Solution {
    public boolean isMatch(String s, String p) {
        int sLen = s.length();
        int pLen = p.length();
        boolean[][] dp = new boolean[sLen+1][pLen+1];
        dp[0][0] = true;
        for(int j = 1; j <= pLen; j++){
            if(p.charAt(j-1) == '*'){
                dp[0][j] = dp[0][j-1];
            }
        }
        
        for(int i = 1; i <= sLen; i++){
            for(int j = 1; j <= pLen; j++){
                char scur = s.charAt(i-1);
                char pcur = p.charAt(j-1);
                if(pcur == '?' || pcur == scur){
                    dp[i][j] = dp[i-1][j-1];
                }
                else if(pcur == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }
            }
        }
        return dp[sLen][pLen];
    }
}