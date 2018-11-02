class Solution {

    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length==0 || nums==null) return 0;
        int i=0, j=0, min=Integer.MAX_VALUE,sum=0;
        while(i<=j && j<nums.length){
            sum+=nums[j++];
            while(sum>=s){
                min=Math.min(j-i,min);
                sum-=nums[i++];
            }
        }

        min = min==Integer.MAX_VALUE?0:min;

        return min;
    }

    //doesnt work :(  Didn't realize it was sum>=s thought it was sum=s
    public int minSubArrayLen1(int s, int[] nums) {
        if(nums.length==0)
            return 0;
        Map<Integer,Integer> map = new HashMap();
        int min = Integer.MAX_VALUE,sum=0;
        map.put(0,0);
        for(int i=1;i<nums.length+1;i++){
            sum+=nums[i-1];
            if(map.containsKey(sum-s)){
                int v = i-map.get(sum-s);
                min = Math.min(min,v);
            }
            map.put(sum,i);
        }
        return min;
    }
}