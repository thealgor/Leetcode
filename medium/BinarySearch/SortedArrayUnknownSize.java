//look at discuss again.
class Solution {
    
   /*To use binary search, we need to find the search space defined by low and hi. Find hi by moving hi exponentially. Once hi is found, low is previous hi. Then do binary search.

*/ 
  public int search(ArrayReader reader, int target) {
    int hi = 1;
    while (reader.get(hi) < target) {
        hi = hi << 1;
    }
    int low = hi >> 1;
    while (low <= hi) {
        int mid = low+(hi-low)/2;
        if (reader.get(mid) > target) {
            hi = mid-1;
        } else if (reader.get(mid) < target) {
            low = mid+1;
        } else {
            return mid;
        }
    }
    return -1;
}
    
    
    
    public int search1(ArrayReader reader, int target) {
        if (target < -9999 || target > 9999) {
            return -1;
        }
        int low = 0, high = 20000;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int i = reader.get(mid);
            if (i == target) {
                return mid;
            } else if (i == Integer.MAX_VALUE || i > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
