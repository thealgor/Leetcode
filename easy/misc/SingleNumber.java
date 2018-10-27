class Solution {
    public int singleNumber(int[] nums) {

        if(nums==null || nums.length==0)
            return -1;
        int result=0;
        for(int n:nums){
            result ^= n;
        }
        return result;

    }
}