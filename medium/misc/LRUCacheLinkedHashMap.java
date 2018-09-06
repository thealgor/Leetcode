package medium.misc;

import java.util.LinkedHashMap;
import java.util.*;

class LRUCache {

    LinkedHashMap<Integer,Integer> map;
    int capacity;
    int index=0;


    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new LinkedHashMap<Integer,Integer>(this.capacity);
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int value = map.get(key);
            map.remove(key,value);
            map.put(key,value);
            return map.get(key);
        }
        else
            return -1;
    }

    public void put(int key, int value) {
        if(map.containsKey(key))
            map.remove(key);

        if(map.size()==this.capacity){
            map.remove(map.entrySet().iterator().next().getKey());
        }

        if(!map.containsKey(key))
            map.put(key,value);
    }
}


public class LRUCacheBetterSolution {
    private LinkedHashMap<Integer, Integer> map;
    private final int CAPACITY;
    public LRUCache(int capacity) {
        CAPACITY = capacity;
        map = new LinkedHashMap<Integer, Integer>(capacity, 0.75f, true){
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > CAPACITY;
            }
        };
    }
    public int get(int key) {
        return map.getOrDefault(key, -1);
    }
    public void set(int key, int value) {
        map.put(key, value);
    }
}


public class LRUCacheJava8 extends LinkedHashMap<Integer, Integer> {

    Predicate<Integer> removeEldestEntry;

    public LRUCache(int capacity) {
        super(capacity, 0.75f, true);
        this.removeEldestEntry = (size) -> size > capacity;
    }

    public int get(int key) {
        Integer value = super.get(key);
        return (value == null) ? -1 : value;
    }

    public void set(int key, int value) {
        put(key, value);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return removeEldestEntry.test(size());
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */