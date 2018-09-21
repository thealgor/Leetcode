package medium.Graphs;

// could be solved with union find as well.
//Has n-1 edges and is acyclic.
//Has n-1 edges and is connected.


class GraphValidTree {
    boolean result = false;
    public boolean validTree(int n, int[][] edges) {
        //make sure all vertices are connected
        //make sure there are no cycles.

        boolean[] visited = new boolean[n];
        //adjacency List
        List<List<Integer>> adj = new ArrayList<List<Integer>>();

        //initiazlie
        for(int i=0;i<n;i++){
            adj.add(0, new ArrayList<Integer>());
        }

        //add edges
        for(int i=0;i<edges.length;i++){
            int u = edges[i][0], v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        //check loop dfs
        if(loopExists(adj,0, visited,-1))
            return false;

        //all vertices are connected
        for(int i=0;i<n;i++){
            if(!visited[i])
                return false;
        }

        return true;
    }

    public boolean loopExists(List<List<Integer>> adj, int u,boolean[] visited, int parent){
        visited[u]=true;
        List<Integer> edges = adj.get(u);
        // check for cycle (but disregard reverse of edge leading to v)
        for(int v: edges){
            System.out.println(u+","+v+","+parent+","+visited[v]);
            if((visited[v] && parent != v) || (!visited[v] && loopExists(adj, v, visited, u))){
                System.out.println("Yo");
                return true;
            }
        }
        return false;
    }






}