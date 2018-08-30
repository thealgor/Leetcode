class NumberOfIslands {

    char[][] g;
    boolean[][] visited;
    public int numIslands(char[][] grid) {

        g=grid;
        if(grid.length==0 || grid[0].length==0)
            return 0;


        int conComponents = 0;
        visited = new boolean[grid.length][grid[0].length];

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'&&!visited[i][j]){
                    dfs(i,j);
                    conComponents++;
                }
            }
        }

        return conComponents;

    }

    public void dfs(int u, int v){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};


        for(int i=0;i<dx.length;i++){
            int x = u+dx[i], y = v+dy[i];

            if(x<0 || y<0 ||x>=g.length||y>=g[0].length)
                continue;

            //System.out.println("g.length: "+ g.length+"g0 length: "+g[0].length);

            if(!visited[x][y]){
                visited[x][y] = true;
                if(g[x][y]=='0')
                    continue;
                dfs(x,y);
            }
        }
    }
}