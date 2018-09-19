package medium.PriorityQueues;

class KthLargestElementInArray {

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
