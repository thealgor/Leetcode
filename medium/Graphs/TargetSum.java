class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[] result = new int[1];
        dfs(nums, S, result,0,0);
        return result[0];
    }

    public void dfs(int[] nums, int S, int[] result, int index, int sum){
        if(sum==S && index==nums.length){
            result[0]++;
        }
        if(index==nums.length) return;
        int[] arr = {1,-1};
        for(int i=0;i<arr.length;i++){
            dfs(nums,S,result,index+1,sum+nums[index]*arr[i]);
        }
    }
}