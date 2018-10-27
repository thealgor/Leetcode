class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums==null || nums.length<1)
            return 0;
        //int[] dp = new int[nums.length];
        //dp[0]=1;
        int max=1; int prev=1;
        for(int i=1;i<nums.length;i++){
            if(nums[i-1]<nums[i]){
                prev=prev+1;
            }
            else
                prev=1;
            max=Math.max(prev,max);
        }
        return max;
    }
}