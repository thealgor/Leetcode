package medium.PriorityQueues;

class KthLargestElementInArray {
    //using selection algorithm
    public int findKthLargest(int[] nums, int k) {

        k = nums.length - k;
        int lo = 0;
        int hi = nums.length - 1;
        while (lo < hi) {
            final int j = partition(nums, lo, hi);
            if(j < k) {
                lo = j + 1;
            } else if (j > k) {
                hi = j - 1;
            } else {
                break;
            }
        }
        return nums[k];
    }

    private int partition(int[] a, int lo, int hi) {

        int i = lo;
        int j = hi + 1;
        while(true) {
            while(i < hi && less(a[++i], a[lo]));
            while(j > lo && less(a[lo], a[--j]));
            if(i >= j) {
                break;
            }
            exch(a, i, j);
        }
        exch(a, lo, j);
        return j;
    }

    private void exch(int[] a, int i, int j) {
        final int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }

    private boolean less(int v, int w) {
        return v < w;
    }
    
    
    
    
    
    
    
    
    
    
    //Min Priority queue
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue(k);
        for(int i = 0;i<k;i++){
            pq.add(nums[i]);
        }

        for(int i=k;i<nums.length;i++){
            int top = pq.peek();
            if(top>=nums[i])
                continue;
            pq.poll();
            pq.add(nums[i]);
        }

        return pq.poll();
    }


    //can be solved with quickselect for theta(N ) average case scenario and O(N2) worst case scenario.

}
