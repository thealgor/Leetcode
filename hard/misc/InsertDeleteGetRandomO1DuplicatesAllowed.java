class RandomizedCollection {

    Map<Integer,Set<Integer>> map;
    Random r;
    List<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedCollection() {
        map = new HashMap<>();
        nums = new ArrayList<>();
        r = new Random();
    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean c = map.containsKey(val);
        if(!c) map.put(val, new HashSet<Integer>());
        map.get(val).add(nums.size());
        nums.add(val);
        return !c;
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)) return false;
        int lastPos = nums.size()-1;
        int lastVal = nums.get(lastPos);
        Set<Integer> set = map.get(val);
        Iterator<Integer> it = set.iterator();
        int v=it.next();
        set.remove(v);
        nums.set(v,lastVal); // updated num
        map.get(lastVal).remove(lastPos);  //forgot this step: should remove the last eleement from the set and also update the last element position.
        map.get(lastVal).add(v);
        nums.remove(lastPos);
        if(!it.hasNext())
            map.remove(val);
        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        return nums.get(r.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */