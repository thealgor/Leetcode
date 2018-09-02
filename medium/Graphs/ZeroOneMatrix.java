package Graphs;


//4:05
//4:11 - 14 minutes realize your solution might not work - wonder why you figured out so late. At this point it is a goner.
//run your algorithm on an example before tryint go solve it.
//solved the problem in 10 minutes once I changed to BFS. When You are like find the shortest distance BFS is a better solution. DFS quickly becomes messy. Try to solve few problems with BFS as well.

//failed test case at 4:36
class ZeroOneMatrix {


    private class Point{
        int x;
        int y;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
        }
    }


    int[][] result;
    int m,n;
    public int[][] updateMatrix(int[][] matrix) {

        if(matrix.length==0||matrix[0].length==0)
            return new int[][]{};

        m = matrix.length; n=matrix[0].length;


        result = new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                result[i][j]=matrix[i][j];

            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    result[i][j]= bfs(matrix,i,j);

                }
            }
        }

        return result;

    }


    public int bfs(int[][] matrix, int u, int v){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        Queue<Point> q = new LinkedList<Point>();
        q.add(new Point(u,v));
        q.add(null);

        int count=0;

        while(!q.isEmpty()){
            Point p = q.remove();
            if(p==null){
                count++;
                if(!q.isEmpty())
                    q.add(null);
            }

            if(p==null)
                continue;

            for(int i=0;i<dx.length;i++){
                int x = p.x+dx[i];
                int y = p.y+dy[i];

                if(x<0||x>m-1||y<0||y>n-1)
                    continue;

                if(matrix[x][y]==0){
                    return count+1;
                }
                else
                    q.add(new Point(x,y));
            }



        }

        return count;

    }




    //dp solution

    public void dpSolution(){
        //First pass: check for left and top
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0)
                    dist[i][j] = 0;
                else {
                    if (i > 0)
                        dist[i][j] = min(dist[i][j], dist[i - 1][j] + 1);
                    if (j > 0)
                        dist[i][j] = min(dist[i][j], dist[i][j - 1] + 1);
                }
            }
        }

        //Second pass: check for bottom and right
        for (int i = rows - 1; i >= 0; i--) {
            for (int j = cols - 1; j >= 0; j--) {
                if (i < rows - 1)
                    dist[i][j] = min(dist[i][j], dist[i + 1][j] + 1);
                if (j < cols - 1)
                    dist[i][j] = min(dist[i][j], dist[i][j + 1] + 1);
            }
        }

        return dist;
    }




}