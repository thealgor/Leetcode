class Solution {
    public boolean isBipartite(int[][] graph) {
        if(graph.length==0)
            return true;

        Map<Integer,Integer> map = new HashMap();


        for(int i=0;i<graph.length;i++){ //this for loop is to check the extra unconnected components.
            if(map.containsKey(i)) continue;
            Queue<Integer> q = new LinkedList();
            q.add(i);
            //q.add(Integer.MAX_VALUE);
            map.put(i,0);

            while(!q.isEmpty()){
                int u = q.poll();
                int c1 = map.get(u);
                for(int n: graph[u]){
                    if(!map.containsKey(n)){
                        map.put(n,c1==0?1:0);
                        q.add(n);
                    }
                    else{
                        if(map.get(n)==c1)
                            return false;
                    }
                }
            }


        }

        return true;

    }
}