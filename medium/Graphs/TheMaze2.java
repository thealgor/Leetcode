
//got this question wrong at multiple levels - learn dijkstra.
//1. I was adding visited. When I have visited what happens when the cost is lower when we come from a different place. But, we also don't wnat to be going back and forth and causing time limit exception.
//2. Was using previous cost to find solution - this can and will always go wrong.
//3. how to run without visited. if the cost is less than previous cost only then add to the queue otherewise don't.

class Solution {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        Queue<Point> q = new LinkedList();
        Map<Point,Integer> map = new HashMap();
        Point p = new Point(start[0],start[1]);
        map.put(p,0);
        q.add(p);
        int result = Integer.MAX_VALUE;

        while(!q.isEmpty()){
            Point p1 = q.poll();
            if(true){
                int[] dx = {1,-1,0,0};
                int[] dy = {0,0,1,-1};

                int u = p1.x;
                int v = p1.y;

                for(int i=0;i<dx.length;i++){
                    int x = u +dx[i];
                    int y = v +dy[i];
                    int count = 0;

                    while((x>=0 && x<maze.length && y>=0 && y<maze[0].length &&maze[x][y]==0)){
                        x+=dx[i];
                        y+=dy[i];
                        count++;
                    }

                    int m = (x-dx[i]);
                    int n = (y-dy[i]);

                    Point p2 = new Point(m,n);

                    if(map.get(p1)+count < map.getOrDefault(p2,Integer.MAX_VALUE)){
                        map.put(p2, map.get(p1)+count);
                        q.add(p2);
                    }

                    if(m==destination[0]&&n==destination[1])
                        result = Math.min(map.get(p2), result);
                }

            }

        }

        if(result==Integer.MAX_VALUE)
            return -1;
        else
            return result;
    }


    public class Point{
        int x;
        int y;
        // int cost=Integer.MAX_VALUE;
        public Point(int x, int y){
            this.x=x;
            this.y=y;
            //this.cost = Math.min(this.cost,cost);
        }

        @Override
        public int hashCode(){
            int prime = 31;
            int result = 1;
            result *= this.x;
            result *= this.y;
            return result;

        }

        @Override
        public boolean equals(Object o){
            Point p = (Point)o;
            return  (this.x==p.x && this.y==p.y);
        }


    }

}