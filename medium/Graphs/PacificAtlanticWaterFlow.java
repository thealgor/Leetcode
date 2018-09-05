package Graphs;

class PacificAtlanticWaterFlow {

    int[][] matrix;
    int m, n;

    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<int[]>();

        if(matrix.length==0||matrix[0].length==0)
            return result;

        this.matrix = matrix;
        m = matrix.length;
        n = matrix[0].length;

        boolean[][] visited;
        boolean[] oceans = new boolean[2];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                oceans[0]=false;
                oceans[1]=false;
                visited = new boolean[m][n];
                dfs(i,j,visited,oceans);
                if(oceans[0] & oceans[1]){
                    int[] index = new int[2];
                    index[0]=i;
                    index[1]=j;
                    result.add(index);
                }
            }
        }
        return result;
    }


    public void dfs(int u, int v, boolean[][] visited,boolean[] oceans){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        visited[u][v]=true;

        if(u==0||v==0){
            oceans[0]=true;
        }
        if(u==m-1||v==n-1){
            oceans[1]=true;
        }

        if(oceans[0] && oceans[1])
            return;

        for(int i=0;i<dx.length;i++){
            int x = dx[i]+u;
            int y = dy[i]+v;

            if(x<0||y<0||x>m-1||y>n-1)
                continue;

            if(visited[x][y])
                continue;

            if(matrix[u][v]<matrix[x][y])
                continue;

            dfs(x,y,visited,oceans);
        }

    }



}