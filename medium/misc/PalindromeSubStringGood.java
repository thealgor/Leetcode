public class SolutionExpandAroundCenter1 {
    int count = 0;

    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        for (int i = 0; i < s.length(); i++) { // i is the mid point
            extendPalindrome(s, i, i); // odd length;
            extendPalindrome(s, i, i + 1); // even length
        }

        return count;
    }

    private void extendPalindrome(String s, int left, int right) {
        while (left >=0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++; left--; right++;
        }
    }
}






class SolutionExpandAroundCenter {
    public int countSubstrings(String S) {
        int N = S.length(), ans = 0;
        for (int center = 0; center <= 2*N-1; ++center) {
            int left = center / 2;
            int right = left + center % 2;
            while (left >= 0 && right < N && S.charAt(left) == S.charAt(right)) {
                ans++;
                left--;
                right++;
            }
        }
        return ans;
    }
}


class Solution {
    public int countSubstringsExtendingSubsequence(String s) {
        int[][] dp = new int[s.length()][s.length()];
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = 1;
            count++;
            //System.out.println("iter:"+count++);
            for (int j = i+1; j < s.length(); j++) {
                //printMatrix(dp);
                if (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]==j-i-1) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                    count++;
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return count;
    }

    public int countSubstringsExtension(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            dp[i][i] = true;
            count++;
            //System.out.println("iter:"+count++);
            for (int j = i+1; j < s.length(); j++) {
                //printMatrix(dp);
                if (s.charAt(i) == s.charAt(j) &&(j-i<3 || dp[i+1][j-1])) {
                    dp[i][j] = true;
                    count++;
                }
            }
        }
        return count;
    }

    //same solution as above, but more cleaner - missed j-i<3
    public int countSubstrings(String s) {
        int n = s.length();
        int res = 0;
        boolean[][] dp = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i < 3 || dp[i + 1][j - 1]);
                if(dp[i][j]) ++res;
            }
        }
        return res;
    }

}