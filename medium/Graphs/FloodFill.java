class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0)
            return image;
        Set<String> visited = new HashSet();
        int color = image[sr][sc];
        dfs(image, sr, sc,newColor,visited,color);
        return image;
    }


    public void dfs(int[][] image, int u, int v, int newColor, Set<String> visited, int color){
        visited.add(u+","+v);
        image[u][v]=newColor;
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        for(int i=0;i<dx.length;i++){
            int x = u+dx[i];
            int y = v+dy[i];

            if(x<0 || y<0 || x>image.length-1 || y> image[0].length-1 || visited.contains(x+","+y) || image[x][y]!=color ) continue;
            dfs(image,x,y,newColor,visited,color);

        }
    }
}