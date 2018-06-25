package misc;

/**
 * Created by sunil.kksubramanyam on 6/25/18.
 */
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> ns = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            int t = target - nums[i];
            if(ns.containsKey(t)&&ns.get(t)!=i)
                return new int[]{i,ns.get(t)};
            ns.put(nums[i],i);
        }
        throw new IllegalArgumentException("Solution doesn't exist");
    }

}