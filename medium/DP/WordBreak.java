package medium.DP;



class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> wordSet = new HashSet<String>(wordDict);
        int m = s.length();
        if(m==0)
            return true;
        Queue<Integer> q = new LinkedList<Integer>();
        int[] visited = new int[s.length()];
        q.add(0);
        while(!q.isEmpty()){
            int start = q.remove();

            if(visited[start]==0){
                for(int j=start+1;j<m+1;j++){
                    if(wordSet.contains(s.substring(start,j))){
                        q.add(j);
                        if(j==m)
                            return true;
                    }
                }
                visited[start]=1;
            }
        }
        return false;

    }

    public boolean wordBreakDP(String s, List<String> wordDict){
        int m = s.length();
        if(m==0)
            return true;
        Set<String> wordSet = new HashSet<String>(wordDict);
        boolean[] dp = new boolean[m+1];
        dp[0]=true;
        for(int i=1;i<m+1;i++){
            for(int j=0;j<i;j++){
                if(dp[j]&&wordSet.contains(s.substring(j,i))){
                    dp[i]=true;
                }
            }
        }
        return dp[m];
    }
}