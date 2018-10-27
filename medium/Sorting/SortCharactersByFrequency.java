class Solution {
    public String frequencySort(String s) {
        if(s==null || s.equals(""))
            return s;
        Map<Character,Integer> map = new TreeMap();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i),0)+1);
        }

        List<Character>[] list = new List[s.length()+1];

        for(Map.Entry<Character,Integer> entry: map.entrySet()){
            int freq = entry.getValue();
            char c = entry.getKey();
            System.out.println(freq+":"+c);
            if(list[freq]==null)
                list[freq] = new ArrayList<Character>();
            list[freq].add(c);
        }

        StringBuilder sb = new StringBuilder();
        for(int i=list.length-1;i>=0;i--){
            List<Character> ls = list[i];
            if(ls==null) continue;
            for(int k=0;k<ls.size();k++)
                for(int j=0;j<i;j++)
                    sb.append(ls.get(k));
        }

        return new String(sb);

    }

    //O(nlogm), m is the distinguish character, can be O(1) since only 26 letters. So the overall time complexity should be O(n), the same as the buck sort with less memory use.
    public String frequencySortUsingPQ(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        PriorityQueue<Map.Entry<Character, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        pq.addAll(map.entrySet());

        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry e = pq.poll();
            for (int i = 0; i < (int)e.getValue(); i++)
                sb.append(e.getKey());
        }
        return sb.toString();
    }
}