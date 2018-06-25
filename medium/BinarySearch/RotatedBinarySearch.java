package BinarySearch;

class RotatedBinarySearch {
    public int search(int[] nums, int target) {

        int low = 0, high = nums.length-1, n = nums.length;
        //find the smallest element.
        while(low<high){
            int mid = low + (high-low)/2;
            if(nums[mid]>nums[high])
                low=mid+1;
            else
                high=mid;
        }

        int ro = low;

        low = 0;
        high=nums.length-1;

        while(low<=high){
            int mid = low + (high-low)/2;
            int realmid = (mid+ro)%n;
            if(nums[realmid]==target)
                return realmid;
            else if(nums[realmid]>target)
                high=mid-1;
            else
                low=mid+1;
        }

        return -1;

    }
}