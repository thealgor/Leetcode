package medium.Graphs;

class FriendCircles {
    int m;
    int n;
    public int findCircleNum(int[][] M) {
        if(M.length==0)
            return 0;

        m = M.length;
        n = M[0].length;

        boolean[] visited = new boolean[m];
        int count = 0;

        for(int i=0;i<m;i++){
            if(!visited[i]&&M[i][i]==1){
                dfs1(M,i,visited);
                count++;
            }
        }

        return count;
    }


    public void dfs1(int[][] M, int u, boolean[] visited){
        visited[u]=true;
        for(int i=0;i<n;i++){
            if(visited[i])
                continue;
            if(M[u][i]==1)
                dfs1(M,i,visited);
        }

    }

}
