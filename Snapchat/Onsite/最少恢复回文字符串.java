给一个string,可以add/delete/change，还可以combine几种来使他变为合法的palindrome。
比如：ebabc可以先删了中间的a再把c改成e。问最少需要几步。
分别讨论增加，删除还有修改对应的各个dp的位置，不考虑增加了，只考虑删除和修改，那么修改其实就是往一样了修改，
因为要次数最小么。

class Solution{
	public int calculateModify(String str){
		int len = str.length();
		int[][] dp = new int[len][len];
		// dist指从i到j的距离
		for (int dist = 1; dist < len; dist++) {
			for (int row = len-2; row >= 0; row--) {
				if (row + dist >= len) {
					continue;
				}
				char start = s.charAt(row);
				char end = s.charAt(row+dist);
				if (start == end) {
					dp[row][row+dist] = dp[row+1][row+dist-1];
				}
				else{
					dp[row][row+dist] = 1 + Math.min(dp[row+1][row+dist], 
						Math.min(dp[row][row+dist-1], dp[row+1][row+dist-1]));
				}
			}
		}
		return dp[0][len-1];
	}
}