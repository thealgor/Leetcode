package medium.Graphs;

/**
 * Definition for undirected graph.
 * class UndirectedGraphNode {
 *     int label;
 *     List<UndirectedGraphNode> neighbors;
 *     UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
 * };
 */
public class CloneGraph {



    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if (node == null) {
            return null;
        }
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(node);
        Map<UndirectedGraphNode, UndirectedGraphNode> visited = new HashMap<>();
        visited.put(node, new UndirectedGraphNode(node.label));
        while (!queue.isEmpty()) {
            UndirectedGraphNode graphNode = queue.poll();
            UndirectedGraphNode cloneNode = visited.get(graphNode);
            for (UndirectedGraphNode neighbor : graphNode.neighbors) {
                if (visited.containsKey(neighbor)) {
                    cloneNode.neighbors.add(visited.get(neighbor));
                }
                else{
                    queue.add(neighbor);
                    UndirectedGraphNode cloneNeighbor = new UndirectedGraphNode(neighbor.label);
                    visited.put(neighbor, cloneNeighbor);
                    cloneNode.neighbors.add(cloneNeighbor);
                }
            }
        }
        return visited.get(node);
    }

}