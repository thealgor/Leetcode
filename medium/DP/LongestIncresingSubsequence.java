package DP;

/**
 * Could you improve it to O(n log n) time complexity?
 */

class Solution {
    public int lengthOfLIS(int[] nums) {

        if(nums.length<1)
            return 0;

        int maxSubsequence=1;

        int[] lis = new int[nums.length];

        for(int i=0;i<lis.length;i++)
            lis[i]=1;

        for(int i=1;i<nums.length;i++){
            for(int j=1;j<nums.length;j++){
                if(i>=j && lis[i-j]>=lis[i]&&nums[i-j]<nums[i]){
                    lis[i]=lis[i-j]+1;
                    if(lis[i]>maxSubsequence)
                        maxSubsequence = lis[i];
                }
            }
        }
        return maxSubsequence;

    }
}