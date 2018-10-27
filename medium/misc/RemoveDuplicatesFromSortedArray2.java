class Solution {
    public int removeDuplicates1(int[] nums) {
        if(nums==null || nums.length==0)
            return 0;
        int count = 0, tail = 0, totalCount=0;
        for(int i=0;i<nums.length;i++){
            if(i==0 || (count<2 && nums[i]==nums[i-1])){
                nums[tail++]=nums[i];
                count++;
                totalCount++;
            }
            else if(nums[i]>nums[i-1]){
                count=1;
                nums[tail++]=nums[i];
                totalCount++;
            }
            else
                continue;
        }
        return totalCount;
    }

    //better solution
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums)
            if (i < 2 || n > nums[i-2])
                nums[i++] = n;
        return i;
    }
}