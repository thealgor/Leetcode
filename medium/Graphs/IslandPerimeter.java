public class Solution {
    public int islandPerimeter(int[][] grid) {
        int islands = 0, neighbours = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    islands++; // count islands
                    if (i < grid.length - 1 && grid[i + 1][j] == 1) neighbours++; // count down neighbours
                    if (j < grid[i].length - 1 && grid[i][j + 1] == 1) neighbours++; // count right neighbours
                }
            }
        }

        return islands * 4 - neighbours * 2;
    }
}






class Solution1 {


    public int islandPerimeter(int[][] grid) {

        int[] result = new int[1];
        int r = 0;
        int m = grid.length, n = grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    Set<String> visited = new HashSet();
                    r = bfs(grid,visited, i, j);
                    return r;

                }

            }
        }
        return r;
    }

    public int bfs(int[][] grid, Set<String> visited, int u, int v){
        int[] counts = {4,3,2,1,0};

        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        Queue<String> q = new LinkedList();
        q.add(u+","+v);
        int res = 0;
        visited.add(u+","+v);

        while(!q.isEmpty()){
            System.out.println(q);
            String[] p = q.poll().split(",");
            int p1 = Integer.parseInt(p[0]);
            int p2= Integer.parseInt(p[1]);

            int count = 0;
            for(int i=0;i<dx.length;i++){
                int x = p1+dx[i];
                int y = p2+dy[i];
                if(x<0 || y<0 || x>grid.length-1 || y>grid[0].length-1){ count++; continue;}

                if(grid[x][y]==0)
                    count++;

                if(!visited.contains(x+","+y) && grid[x][y]==1){
                    q.add(x+","+y);
                    visited.add(x+","+y);
                }
                System.out.println(q);
            }
            System.out.println(count);

            res+=count;

        }
        return res;

    }
}