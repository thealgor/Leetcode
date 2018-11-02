
//missed out on the definition of roll. Took quite long time after viewing multiple solutions to figure this out.
class Solution {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        if(maze==null || maze.length==0)
            return false;
        Set<String> visited = new HashSet();
        return hasPath(maze,start[0], start[1], destination, visited);
    }

    public boolean hasPath(int[][] maze, int u, int v, int[] destination, Set<String> visited){
        visited.add(u+","+v);
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};

        if(u==destination[0] && v==destination[1])
            return true;

        for(int i=0;i<dx.length;i++){
            int x = u+dx[i];
            int y = v+dy[i];

            while((x>=0 && y>=0 && x<=maze.length-1 && y<=maze[0].length-1 && maze[x][y]==0)){
                x+=dx[i];
                y+=dy[i];
            }
            boolean result = false;
            if(!visited.contains((x-dx[i]) +","+(y-dy[i]))){
                result = hasPath(maze, x-dx[i], y-dy[i],destination,visited);
                if(result)
                    return true;
            }

        }

        return false;
    }


}