package medium.Graphs;

class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0 ||
                prerequisites[0] == null || prerequisites[0].length == 0) {
            return true;
        }

        int[][] adj = new int[numCourses][numCourses];
        int[] indegree = new int[numCourses];
        Queue<Integer> q = new LinkedList<Integer>();

        //fill up the adjacency matrix

        for(int i=0;i<prerequisites.length;i++){
            int left = prerequisites[i][0];
            int right = prerequisites[i][1];
            //System.out.prtinln(adj.length+", "+adj[0].length);
            if(adj[left][right]==0)
                adj[left][right]++;

            indegree[right]++;
        }


        for(int i=0;i<indegree.length;i++){
            if(indegree[i]==0)
                q.offer(i);
        }

        int count = 0;

        while(!q.isEmpty()){
            int v = q.poll();
            count++;

            for(int i=0;i<adj.length;i++){

                if(adj[v][i]!=0)
                    if(--indegree[i]==0)
                        q.offer(i);
            }

        }

        return count == numCourses;


    }
}


public  class  Solution {
    HashMap<Integer, List<Integer>> map;
    int[] visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0 ||
                prerequisites[0] == null || prerequisites[0].length == 0) {
            return true;
        }
        visited = new int[numCourses];
        map = new HashMap<Integer, List<Integer>>();
        //Put all start node into map.
        for (int i = 0; i < prerequisites.length; i++) {
            if (!map.containsKey(prerequisites[i][1])) {
                map.put(prerequisites[i][1], new ArrayList<Integer>());
            }
            map.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        //dfs on each start node in the pair
        for (int i = 0; i < prerequisites.length; i++) {
            if (!dfs(prerequisites[i][0])) {
                return false;
            }
        }

        return true;
    }

    public  boolean  dfs ( int  node ) {
        if (visited[node] == 1) {//has been through this path, true.
            return true;
        }
        if (visited[node] == -1) {//visiting a visited node from a deper level node, cycle
            return false;
        }
        //mark it -1 then after dfs mark it 1. Marking and backtracking skills
        visited[node] = -1;

        //Visit each child and make sure there is no cycle.
        if (map.containsKey(node)) {
            for (int nextNode : map.get(node)) {
                if (!dfs(nextNode)) {
                    return false;
                }
            }
        }

        visited[node] = 1;
        return true;
    }

}


