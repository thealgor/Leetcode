class Solution {
    public String longestPalindromeSubsequenceSolutionExtension(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int max=0; String result="";

        for(int i=s.length()-1;i>=0;i--){
            dp[i][i]=1;

            if(max<dp[i][i]){
                result = s.substring(i,i+1);
                max=dp[i][i];
            }

            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==j-i-1){
                    dp[i][j]=dp[i+1][j-1]+2;
                    if(max<dp[i][j]){
                        result = s.substring(i,i+dp[i][j]);
                        max=dp[i][j];
                    }
                }
                else{
                    dp[i][j]=Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return result;
    }


    public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int max=0; String result="";

        for(int i=s.length()-1;i>=0;i--){
            dp[i][i]=true;

            if(max<1){
                result = s.substring(i,i+1);
                max=1;
            }

            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j) && (dp[i+1][j-1]||j-i<3)){
                    dp[i][j]=true;
                    if(max<(j-i+1)){
                        result = s.substring(i,j+1);
                        max=j-i;
                    }
                }
            }
        }
        return result;
    }
}

//Expand around center
class SolutionExpandAroundCenter {
    private int lo, maxLen;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len < 2)
            return s;

        for (int i = 0; i < len-1; i++) {
            extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
            extendPalindrome(s, i, i+1); //assume even length.
        }
        return s.substring(lo, lo + maxLen);
    }

    private void extendPalindrome(String s, int j, int k) {
        while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
            j--;
            k++;
        }
        if (maxLen < k - j - 1) {
            lo = j + 1;
            maxLen = k - j - 1;
        }
    }
}

//expand around center.
class SolutionWithoutGlobalVariables{
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
