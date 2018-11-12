package BinarySearch;

class RotatedBinarySearch {
    
    public int search(int[] nums, int target) {
          if(nums==null || nums.length==0)
            return -1;
        int lo=0, hi=nums.length-1;
        while(lo<hi){
            int mid = (lo+hi)/2;
            if(nums[mid]==target) return mid;
            if(nums[mid]>=nums[lo]){
                if(target>=nums[lo]&&target<nums[mid]) hi=mid-1;
                else lo=mid+1;
                
            }
            else{
                if(target>nums[mid]&&target<=nums[hi]) lo=mid+1;
                else hi=mid-1;
            }
        }
       return nums[lo] == target ? lo : -1;
    }
    
    
    
    
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
