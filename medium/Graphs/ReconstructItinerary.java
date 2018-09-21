package medium.Graphs;

class ReconstructItinerary {
    Map<String,PriorityQueue<String>> map;
    String[][] t;
    public List<String> findItinerary(String[][] tickets) {
        t=tickets;
        map = new HashMap<String,PriorityQueue<String>>();
        for(int i=0;i<tickets.length;i++)
            map.computeIfAbsent(tickets[i][0], k -> new PriorityQueue()).add(tickets[i][1]);
        List<String> result = new LinkedList<String>();
        dfs("JFK",result);
        return result;

    }


    public void dfs(String start, List<String> result){

        PriorityQueue<String> arrivals = map.get(start);

        while(arrivals!=null && !arrivals.isEmpty())
            dfs(arrivals.poll(),result);
        result.add(0,start);


    }


}