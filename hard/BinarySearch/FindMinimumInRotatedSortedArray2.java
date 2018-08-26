/*
* failed on this use case: [3,3,1,3]
* failed on this case: [10,1,10,10,10]
* basically tried fliping equal to to above condition or below condition, one of the two will always fail.
*/


class Solution {
    public int findMin(int[] nums) {

        int lo=0, hi=nums.length-1;



        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            if(nums[mid]>nums[hi])
                lo=mid+1;
            else if(nums[mid]<nums[hi])
                hi=mid;
            else
                hi--;
        }
        return nums[lo];

    }
}