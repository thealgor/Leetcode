class Solution {

    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        boolean reachedEnd = false;
        return canJump(nums,0,dp);
    }

    boolean canJump(int[] nums, int index, int[] dp){


        if(index==nums.length-1)
            return true;

        if(index<0)
            return false;

        if(index>nums.length-1)
            return false;

        int max = nums[index];

        if(max==0)
            return false;

        if(dp[index]==-1)
            return false;

        while(max>0){
            boolean val = canJump(nums,max+index,dp);

            if(max+index<dp.length && !val)
                dp[max+index]=-1;

            if(val)
                return true;
            max=max-1;
        }

        return false;

    }


}