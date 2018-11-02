class Solution {
    public void sortColors(int[] nums) {
        int first = 0, last = nums.length-1,i=0;
        while(i<=last){
            if(nums[i]==2){
                swap(nums,i,last);
                last--;
            }
            else if(nums[i]==0){
                swap(nums,i,first);
                first++;
                i++;
            }
            else
                i++;
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}