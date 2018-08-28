package BinarySearch;

/**
 * Start time: 9:20
 * corner cases: 1 1
 * corner cases 1 3 3
 *
 */


class Solution {
    public int findDuplicate(int[] nums) {
        int result = findDuplicatesSort(nums);
        int result1 = findDuplicatesTortoiseHare(nums);
        return result1;
    }

    public int findDuplicatesTortoiseHare(int[] nums){
        int tortoise=nums[0];
        int hare = nums[0];
        do{
            tortoise=nums[tortoise];
            hare=nums[nums[hare]];
        }while(tortoise!=hare);

        int ptr1=nums[0];
        int ptr2=tortoise;

        while(ptr1!=ptr2){
            ptr1 = nums[ptr1];
            ptr2 = nums[ptr2];
        }
        return ptr1;
    }





    public int findDuplicatesSort(int[] nums){
        Arrays.sort(nums);
        int i = 0, len = nums.length;
        while(i<len-1){
            if(nums[i]==nums[i+1])
                return nums[i];
            i++;
        }
        return -1;
    }
}