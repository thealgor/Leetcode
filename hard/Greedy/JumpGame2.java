class Solution {

    //O(n) and O(1) solution. Find the maximum index you can reach from the current node and find the next between the current start to max.
    /**
     * I try to change this problem to a BFS problem, where nodes in level i are all the nodes that can be reached in i-1th jump. for example. 2 3 1 1 4 , is
     2||
     3 1||
     1 4 ||


     */


    public int jump(int[] nums) {
        int n = nums.length;
        if(n<2) return 0;
        int i=0, currMax=0, nextMax=0,level=0;
        while(i<=currMax){
            for(;i<=currMax;i++){
                nextMax=Math.max(nextMax,nums[i]+i); //find the maximum reachable index from the current node.
                if(nextMax>=n-1)return level+1;
            }
            currMax=nextMax;
            level++;
        }
        return level;

    }

    //brute force
    public int jump1(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++){
            for(int j=1;j<=nums[i];j++){
                if(i+j<n){
                    dp[i+j]=Math.min(dp[i+j],dp[i]+1);
                }
            }
        }
        return dp[n-1];
    }
}