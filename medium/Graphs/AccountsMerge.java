
//could be also solved with union find, but I don't know the algorithm. Need to spend more time on that.
class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> graph = new HashMap(); //email to its edges 1st email and 2nd email share an edge 2nd and 3rd share
        Map<String,String> emailToName  = new HashMap();

        for(List<String> list : accounts){
            String name = list.get(0);
            for(int i=1;i<list.size();i++){
                graph.computeIfAbsent(list.get(i), x-> new ArrayList());
                emailToName.put(list.get(i),name);
                if(i==1) continue;
                graph.get(list.get(i)).add(list.get(i-1));
                graph.get(list.get(i-1)).add(list.get(i));
            }
        }


        Set<String> visited = new HashSet();
        for(Map.Entry<String,String> entry:emailToName.entrySet()){
            String email = entry.getKey();
            if(!visited.contains(email)){
                List<String> l = new ArrayList();
                dfs(email,l,graph,visited);
                Collections.sort(l);
                l.add(0,emailToName.get(email));
                result.add(l);
            }
        }
        return result;
    }

    public void dfs(String email, List<String> l, Map<String,List<String>> graph,Set<String> visited){
        visited.add(email);
        l.add(email);

        for(String e: graph.get(email)){
            if(!visited.contains(e)){
                dfs(e,l,graph,visited);
            }
        }

    }
}