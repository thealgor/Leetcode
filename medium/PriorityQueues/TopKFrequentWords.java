package medium.PriorityQueues;

class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        for(String word: words){
            map.putIfAbsent(word,0);
            map.put(word, map.get(word)+1);
        }

        //  System.out.println(map);

        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue(k,
                (o1,o2) -> {
                    Map.Entry<String,Integer> i1 = (Map.Entry<String,Integer>)o1;
                    Map.Entry<String,Integer> i2 = (Map.Entry<String,Integer>)o2;
                    int cmp = Integer.compare(i1.getValue(),i2.getValue());
                    if(cmp==0)
                        return -i1.getKey().compareTo(i2.getKey());
                    else
                        return cmp;
                });

        Iterator<Map.Entry<String,Integer>> it = map.entrySet().iterator();
        int i=0;
        while(it.hasNext()&&i<k){
            pq.add(it.next());
            i++;
        }

        for(i=k;i<map.size();i++){
            Map.Entry<String, Integer> entry = it.next();
            if(entry.getValue()>pq.peek().getValue()){
                pq.remove();
                pq.add(entry);

            }
            else if(entry.getValue()==pq.peek().getValue()){
                int cmp = pq.peek().getKey().compareTo(entry.getKey());
                System.out.println("inside cmp" + entry);
                if(cmp>0){
                    pq.remove();
                    pq.add(entry);
                }
            }
        }

        Stack<String> r = new Stack<String>();
        Iterator<Map.Entry<String,Integer>> it1 = pq.iterator();
        while(it1.hasNext()){
            r.add(pq.peek().getKey());
            pq.remove();
        }

        List<String> result = new ArrayList<String>();

        while(!r.isEmpty()){
            System.out.println(r.peek());
            result.add(r.pop());
        }

        return result;



    }
}


class SolutionSimple {
    public List<String> topKFrequent(String[] words, int k) {

        List<String> result = new LinkedList<>();
        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i<words.length; i++)
        {
            if(map.containsKey(words[i]))
                map.put(words[i], map.get(words[i])+1);
            else
                map.put(words[i], 1);
        }

        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue()==b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue()-b.getValue()
        );

        for(Map.Entry<String, Integer> entry: map.entrySet())
        {
            pq.offer(entry);
            if(pq.size()>k)
                pq.poll();
        }

        while(!pq.isEmpty())
            result.add(0, pq.poll().getKey());

        return result;
    }
}

