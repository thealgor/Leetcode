class Solution {
    public int[][] updateMatrix(int[][] matrix) {

        if(matrix==null || matrix.length==0)
            return matrix;

        Set<String> visited;

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==1)
                    matrix[i][j]=Integer.MAX_VALUE;
            }
        }

        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]==Integer.MAX_VALUE){
                    visited = new HashSet();
                    bfs(i,j,matrix,visited);
                }

            }
        }
        return matrix;
    }

    public void bfs(int u, int v, int[][] matrix, Set<String> visited){
        visited.add(u+","+v);
        Queue<String> q = new LinkedList();
        q.add(u+","+v);
        q.add(null);
        int cost = 1;
        while(!q.isEmpty()){
            String str = q.poll();

            if(str==null){
                cost+=1;
                if(!q.isEmpty())
                    q.add(null);
                continue;
            }

            String[] ns = str.split(",");
            int x1 = Integer.parseInt(ns[0]);
            int y1 = Integer.parseInt(ns[1]);

            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};
            for(int i=0;i<dx.length;i++){
                int x = dx[i]+x1;
                int y = dy[i]+y1;
                if(x<0|| y<0|| x>matrix.length-1|| y>matrix[0].length-1||visited.contains(x+","+y)) continue;

                if(matrix[x][y]!=0){
                    q.add(x+","+y);
                    visited.add(x+","+y);
                }
                else{
                    matrix[u][v]=Math.min(matrix[u][v],cost);
                    return; //didn't write the return. coded dfs - atleast think if I should code dfs vs bfs
                }
            }
        }



    }

}