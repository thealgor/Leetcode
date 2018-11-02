class Solution {

    //Set<String> visited;
    //no need to have visited. if we can know a way that teh point is not visited in other ways.
    //For DFS solution: https://leetcode.com/problems/walls-and-gates/discuss/72748/Benchmarks-of-DFS-and-BFS

    Queue<String> q;
    public void wallsAndGates(int[][] rooms) {

        if(rooms.length==0)
            return;

        q= new LinkedList();
        for(int i=0;i<rooms.length;i++){
            for(int j=0;j<rooms[0].length;j++){
                if(rooms[i][j]==0){
                    // visited = new HashSet();
                    q.add(i+","+j);   //multi-end bfs as adding all the starting elements at the beginning itself.
                }
            }
        }

        q.add(null);
        bfs(rooms);

    }


    public void bfs(int[][] rooms){

        int cost=1;
        while(!q.isEmpty()){
            String s = q.poll();
            if(s==null){
                cost=cost+1;
                if(!q.isEmpty())
                    q.add(null);
                continue;
            }

            int[] dx = {1,-1,0,0};
            int[] dy = {0,0,1,-1};
            for(int i=0;i<dx.length;i++){
                String[] nums = s.split(",");

                int x = Integer.parseInt(nums[0])+dx[i];
                int y = Integer.parseInt(nums[1])+dy[i];

                if(x<0||y<0||x>rooms.length-1||y>rooms[0].length-1 || rooms[x][y]==-1||rooms[x][y]==0 || rooms[x][y]!=Integer.MAX_VALUE)
                    continue;

                int c = Math.min(cost,rooms[x][y]);

                q.add(x+","+y);
                // visited.add(x+","+y); //shortest ones would reach faster. So, you don't need to worry too much about coming from another step to be shorter.
                rooms[x][y]=c;


            }
        }
    }


}