class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        int s=k;
        if(nums.length==0)
            return 0;
        Map<Integer,Integer> map = new HashMap();
        int max = 0,sum=0;
        map.put(0,0);
        for(int i=1;i<nums.length+1;i++){
            sum+=nums[i-1];
            if(map.containsKey(sum-s)){
                int v = i-map.get(sum-s);
                max = Math.max(max,v);
            }
            if(!map.containsKey(sum)) //remove this if you need minmum length and change the above Math.max to Math.min
                map.put(sum,i);
            //System.out.println(sum)
        }
        return max;
    }
}