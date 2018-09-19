package medium.DP;

class UniquePaths2 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[0][0]==1)
            return 0;

        int[][] paths = new int[m][n];
        paths[0][0]=1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0&&j==0) continue; //already set

                if(obstacleGrid[i][j]==1) paths[i][j]=0; //no paths to me :(

                else{
                    if(i==0)
                        paths[i][j]=paths[i][j-1];
                    else if(j==0)
                        paths[i][j]=paths[i-1][j];
                    else
                        paths[i][j]=paths[i-1][j]+paths[i][j-1];
                }


            }
        }
        return paths[m-1][n-1];


    }




    //Didn't work :(
    int count = 0;
    int m,n;

    public int uniquePathsWithObstacles1(int[][] obstacleGrid) {

        if(obstacleGrid==null || obstacleGrid.length==0||obstacleGrid[0]==null || obstacleGrid[0].length==0)
            return -1;


        m = obstacleGrid.length;
        n = obstacleGrid[0].length;
        boolean[][] visited = new boolean[m][n];
        if(m-1==0 && n-1==0&&obstacleGrid[0][0]==0)
            return 1;
        if(obstacleGrid[0][0]==1)
            return 0;

        dfs(obstacleGrid,0,0,visited);
        return count;
    }


    public void dfs(int[][] grid, int u, int v, boolean[][] visited){

        // visited[u][v]=true;

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        for(int i=0;i<dx.length;i++){
            int x = dx[i]+u;
            int y = dy[i]+v;


            if(x<0||y<0||x>m-1||y>n-1)
                continue;

            if(visited[x][y])
                continue;

            if(grid[x][y]==1)
                continue;

            if(x==m-1&&y==n-1&&grid[x][y]!=1){
                count++;
                continue;
            }
            dfs(grid,x,y,visited);

        }

    }

}
