class Solution {
    public int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==1){
                    StringBuilder sb = new StringBuilder();
                    dfs(grid,i,j,'0',sb);
                    set.add(new String(sb));
                }
            }

        }
        return set.size();
    }

    public void dfs(int[][] grid, int u, int v,char dir, StringBuilder sb){

        if(u<0||v<0 || u>=grid.length || v>=grid[0].length|| grid[u][v]==0) return;
        grid[u][v]=0;
        sb.append(dir);
        dfs(grid,u+1,v,'d',sb);
        dfs(grid,u-1,v,'u',sb);
        dfs(grid,u,v+1,'r',sb);
        dfs(grid,u,v-1,'l',sb);
        sb.append('b');



    }



}