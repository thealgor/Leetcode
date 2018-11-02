class Solution {
    public int countComponents(int n, int[][] edges) {

        Map<Integer, List<Integer>> map = new HashMap();
        Set<Integer> visited = new HashSet();
        for(int[] edge: edges){
            map.computeIfAbsent(edge[0], x-> new ArrayList<Integer>()).add(edge[1]);
            map.computeIfAbsent(edge[1], x-> new ArrayList<Integer>()).add(edge[0]);
        }

        int count=0;
        for(int i=0;i<n;i++){
            if(visited.contains(i)) continue;
            if(map.containsKey(i))
                dfsAdjList(i,map,visited);
            count++;
        }
        return count;

    }

    public void dfsAdjList(int u, Map<Integer,List<Integer>> adj, Set<Integer> visited){
        visited.add(u);
        for(int v: adj.get(u)){
            if(!visited.contains(v))
                dfsAdjList(v,adj,visited);
        }
    }





    public int countComponentsAdjacencyMatrix(int n, int[][] edges) {
        if(edges == null || edges.length==0){
            return n;
        }
        int[][] adj = new int[n][n];

        for(int i=0;i<edges.length;i++){
            adj[edges[i][0]][edges[i][1]]=1;
            adj[edges[i][1]][edges[i][0]]=1;
        }

        Set<Integer> visited = new HashSet();

        int count=0;
        for(int i=0;i<adj.length;i++){
            if(visited.contains(i)) continue;
            dfs(i,adj,visited);
            count++;

        }
        return count;

    }

    public void dfs(int u, int[][] adj, Set<Integer> visited){
        visited.add(u);
        for(int i=0;i<adj[u].length;i++){
            if(visited.contains(i)) continue;

            if(adj[u][i]==1)
                dfs(i,adj,visited);
        }
    }

}

//wrote the crappy code below which obviously didn't work.

//         //System.out.println(u+","+v);

//         int[] dx = {1,-1,0,0,1,-1};
//         int[] dy = {0,0,1,-1,1,-1};

//         for(int i=0;i<dx.length;i++){
//             int x = dx[i]+u;
//             int y = dy[i]+v;
//             int x1 = dx[i]+v;
//             int y1 = dx[i]+u;

//             if(x<0|| y<0 || x>adj.length-1 || y>adj.length-1 || visited.contains(x+","+y) || adj[x][y]==0) continue;

//             dfs(x,y,adj,visited);


//             if(x1<0|| y1<0 || x1>adj.length-1 || y1>adj.length-1 || visited.contains(x1+","+y1) || adj[x1][y1]==0) continue;
//             else
//                 dfs(x1,y1,adj,visited);
//         }

