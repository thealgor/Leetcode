class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int tail = 0;
        int prev = Integer.MAX_VALUE;
        int count = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=prev){
                nums[tail++]=nums[i];
                prev = nums[i];
                count++;
            }
            else{
                continue;
            }
        }
        return count;
    }
}