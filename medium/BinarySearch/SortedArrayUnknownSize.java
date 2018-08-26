//look at discuss again.
class Solution {
    public int search(ArrayReader reader, int target) {
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