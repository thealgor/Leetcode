package hard.misc;

class LFUCache {


    int min = -1,capacity;
    Map<Integer,Integer> keyToValue;
    Map<Integer,Integer> keyToCounts;
    Map<Integer,LinkedHashSet<Integer>> countToLinks;

    public LFUCache(int capacity) {
        keyToValue = new HashMap<>();
        keyToCounts = new HashMap<>();
        countToLinks = new HashMap<>();
        this.capacity = capacity;
        countToLinks.put(1, new LinkedHashSet<>());
    }


    public int get(int key) {
        if(!keyToValue.containsKey(key)) return -1;
        int count = keyToCounts.get(key);
        countToLinks.get(count).remove(key);
        if(count==min && countToLinks.get(count).size()==0)
            min++;
        keyToCounts.put(key,count+1);
        countToLinks.computeIfAbsent(count+1, k -> new LinkedHashSet()).add(key);
        return keyToValue.get(key);

    }

    public void put(int key, int value) {
        if(capacity==0)
            return;

        if(keyToValue.containsKey(key)){
            keyToValue.put(key,value);
            get(key);
            return;
        }
        else if(keyToValue.size()>=capacity){
            int v= countToLinks.get(min).iterator().next();
            countToLinks.get(min).remove(v);
            keyToCounts.remove(v); //can remove this or not
            keyToValue.remove(v);
        }
        keyToCounts.put(key,1);
        keyToValue.put(key,value);
        min=1;
        countToLinks.get(min).add(key);
    }

}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */