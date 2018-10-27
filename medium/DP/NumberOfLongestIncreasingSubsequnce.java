class Solution {
    public int findNumberOfLIS(int[] nums) {

        if(nums==null || nums.length<1)
            return 0;
        int[] count = new int[nums.length];

        int[] dp = new int[nums.length];
        dp[0]=1;
        count[0]=1;
        int max=1;
        for(int i=1;i<nums.length;i++){
            dp[i]=1;count[i]=1;
            for(int j=0;j<i;j++){
                if(nums[j]<nums[i]){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        count[i]=count[j];
                    }
                    else if (dp[j]+1 == dp[i])
                        count[i] += count[j];

                }

            }
            max=Math.max(dp[i],max);

        }


        int result = 0;

        for(int i=0;i<count.length;i++){
            if(dp[i]==max)
                result+=count[i];
        }


        System.out.println(Arrays.toString(count));
        System.out.println(Arrays.toString(dp));
        return result;

    }
}