package medium.DP;

class MaximumProductSubarray {
    public int maxProduct1(int[] nums) {
        int n=nums.length;
        int[][] dp = new int[n][n];
        int max = Integer.MIN_VALUE;

        if(n==0)
            return 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>j)
                    continue;
                if(i==j)
                    dp[i][j]=nums[i];
                else
                    dp[i][j]=dp[i][j-1]*nums[j];
                max=Math.max(dp[i][j],max);
            }
        }
        return max;
    }


    //O(n) solution
    public int maxProduct(int[] nums) {
        int globalMax = nums[0];

        int iMax = 1;
        int iMin = 1;

        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);

            if(nums[i]<0){
                int temp = iMax;
                iMax = iMin;
                iMin=temp;
            }


            iMax = Math.max(nums[i],iMax*nums[i]);
            iMin = Math.min(nums[i],iMin*nums[i]);


            globalMax = Math.max(globalMax,iMax);

        }
        return globalMax;

    }
}