package DP;

/**
 * 11 minutes solving time
 *
 *
 */
class Solution {
    public int maxSubArray(int[] nums) {

        if(nums.length==0)
            return -1;

        int result = nums[0];

        int[] subArraySum = new int[nums.length];

        subArraySum[0]=nums[0];

        for(int i=1;i<nums.length;i++){
            subArraySum[i] = Math.max((subArraySum[i-1]+nums[i]),nums[i]);
            if(result<subArraySum[i])
                result =subArraySum[i];
        }
        return result;

    }
}