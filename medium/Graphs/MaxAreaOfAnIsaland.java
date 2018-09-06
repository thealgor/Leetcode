package medium.Graphs;

class MaxAreaOfAnIsland {

    boolean[][] visited;
    int[][] g;
    int max = 0;
    int localMax=0;

    public int maxAreaOfIsland(int[][] grid) {


        if(grid.length<=0 || grid[0].length<=0)
            return 0;


        visited = new boolean[grid.length][grid[0].length];
        g=grid;



        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(!visited[i][j]&&grid[i][j]!=0)  {
                    localMax=0;
                    dfs(i,j,1);
                    max=Math.max(1,max);

                }
            }
        }
        return max;

    }


    public void dfs(int u, int v, int cost){

        visited[u][v]=true;

        int[] dx={1,-1,0,0};
        int[] dy={0,0,1,-1};

        for(int i=0;i<dx.length;i++){
            int x = u+dx[i];
            int y = v+dy[i];

            if(x<0||x>=g.length||y<0||y>=g[0].length)
                continue;

            // System.out.println("x: "+x+"y: "+y);
            if(!visited[x][y]&&g[x][y]!=0){

                cost+=g[x][y];
                localMax = Math.max(cost,(localMax+1));
                //System.out.println(localMax);
                max = Math.max(max,localMax);
                dfs(x,y,cost);
            }

        }

    }



}

class Solution {
    int[][] grid;
    boolean[][] seen;

    public int area(int r, int c) {
        if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length ||
                seen[r][c] || grid[r][c] == 0)
            return 0;
        seen[r][c] = true;
        return (1 + area(r+1, c) + area(r-1, c)
                + area(r, c-1) + area(r, c+1));
    }

    public int maxAreaOfIsland(int[][] grid) {
        this.grid = grid;
        seen = new boolean[grid.length][grid[0].length];
        int ans = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                ans = Math.max(ans, area(r, c));
            }
        }
        return ans;
    }
}