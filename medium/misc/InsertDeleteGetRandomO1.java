class RandomizedSet {

    Random r;
    Map<Integer,Integer> map;
    List<Integer> nums;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        map = new HashMap<Integer,Integer>();
        nums = new ArrayList<Integer>();
        r = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {

        if(map.containsKey(val)) return false;
        map.put(val,nums.size());
        nums.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        //don't remove the element directly. As you need to preserve the positions. swap with last element and remove the last element.
        if(!map.containsKey(val)) return false;
        int pos = map.get(val);
        int lastPos = nums.size()-1;
        int lastVal = nums.get(nums.size()-1);
        nums.set(pos, lastVal);
        nums.remove(nums.size()-1);
        map.put(lastVal,pos);
        map.remove(val);
        return true;

    }

    /** Get a random element from the set. */
    public int getRandom() {
        return nums.get(r.nextInt(nums.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */