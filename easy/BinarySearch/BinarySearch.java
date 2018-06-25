package BinarySearch;

class BinarySearch {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1;
        while(lo<=hi){
            int mid = lo + (hi - lo)/2;
            System.out.println(lo+","+hi+","+mid);
            if(nums[mid]>target)
                hi = mid-1;
            else if(nums[mid]<target)
                lo = mid+1;
            else
                return mid;
        }
        return -1;
    }
}
