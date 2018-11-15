注意一下，如果没有rotate的话，是升序的，那么就直接返回nums[0]就行。

public class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1) return nums[0];
        int start = 0;
        int end = nums.length-1;
        int middle = 0;
        while(start + 1 < end){
            middle = start + (end-start)/2;
            if(nums[middle] < nums[end]){
                end = middle;
            }
            else if(nums[middle] > nums[start]){
                start = middle;
            }
            else{
                return nums[0];
            }
        }
        if(nums[start] < nums[end]){
            return nums[start];
        }
        return nums[end];
    }
}