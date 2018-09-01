/**
 * 20 minutes to solve the problem. Had errors in my thinking. robberer can skip 2 houses to maximize profit.
 * can be solved in O(n) time and O(1) space. Unfortunately, my solution is O(n2) time and O(n) space.
 *
 */

class HouseRobber {
    public int rob(int[] nums) {

        int m = nums.length;
        if(m==0)
            return 0;
        if(m==1)
            return nums[0];
        int max = -1;
        int[] dp = new int[nums.length];
        dp[0]=nums[0]; dp[1]=nums[1];
        max = Math.max(dp[0],dp[1]);
        for(int i=2;i<nums.length;i++){
            for(int j=0;j<=i-2;j++) {
                dp[i]=Math.max(dp[i],(nums[i]+dp[j]));
                max = Math.max(dp[i],max);
            }
        }
        return max;

    }
    //O(n) time and O(1) space
    public int rob1(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }
}