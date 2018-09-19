package medium.misc;

class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c: tasks){
            map.putIfAbsent(c,0);
            map.put(c,map.get(c)+1);
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<Map.Entry<Character,Integer>>((m1, m2) -> -Integer.compare(m1.getValue(), m2.getValue()));

        //O(1) as only max 26 elements.
        pq.addAll(map.entrySet());

        int count = 0;
        while(!pq.isEmpty()){

            int key = n+1;
            List<Map.Entry<Character,Integer>> list = new ArrayList<Map.Entry<Character,Integer>>();
            while(!pq.isEmpty() && key>0){
                Map.Entry<Character,Integer> curr = pq.poll();
                //decrease the frequency
                curr.setValue(curr.getValue()-1);
                list.add(curr);
                key--;
                count++;
                // System.out.println(curr.getKey()+","+curr.getValue());
            }

            for(Map.Entry<Character,Integer> entry: list){
                if(entry.getValue()>0) pq.add(entry);
            }

            if(pq.isEmpty()) break;
            if(key!=0)
                count = count+key;

        }

        return count;

    }
}