
class Solution {
    //O(n) asymptotic solution
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] res={};
        if(nums==null || nums.length==0 || nums.length<k)
            return res;
        res = new int[nums.length-k+1];
        Deque<Integer> dq = new ArrayDeque();
        int idx=0;
        for(int i=0;i<nums.length;i++){
            if(!dq.isEmpty() && dq.peek() < i-k+1){
                dq.pollFirst();
            }

            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            dq.offer(i);

            if(i-k + 1 >=0){
                res[idx++] = nums[dq.peek()];
            }


        }

        return res;
    }

    /**
     * For Example: A = [2,1,3,4,6,3,8,9,10,12,56], w=4

     partition the array in blocks of size w=4. The last block may have less then w.
     2, 1, 3, 4 | 6, 3, 8, 9 | 10, 12, 56|

     Traverse the list from start to end and calculate max_so_far. Reset max after each block boundary (of w elements).
     left_max[] = 2, 2, 3, 4 | 6, 6, 8, 9 | 10, 12, 56

     Similarly calculate max in future by traversing from end to start.
     right_max[] = 4, 4, 4, 4 | 9, 9, 9, 9 | 56, 56, 56

     now, sliding max at each position i in current window, sliding-max(i) = max{right_max(i), left_max(i+w-1)}
     sliding_max = 4, 6, 6, 8, 9, 10, 12, 56
     */

    public static int[] slidingWindowMax2(final int[] in, final int w) {
        final int[] max_left = new int[in.length];
        final int[] max_right = new int[in.length];

        max_left[0] = in[0];
        max_right[in.length - 1] = in[in.length - 1];

        for (int i = 1; i < in.length; i++) {
            max_left[i] = (i % w == 0) ? in[i] : Math.max(max_left[i - 1], in[i]);

            final int j = in.length - i - 1;
            max_right[j] = (j % w == 0) ? in[j] : Math.max(max_right[j + 1], in[j]);
        }

        final int[] sliding_max = new int[in.length - w + 1];
        for (int i = 0, j = 0; i + w <= in.length; i++) {
            sliding_max[j++] = Math.max(max_right[i], max_left[i + w - 1]);
        }

        return sliding_max;
    }





    //O(nk) solution.
    public int[] maxSlidingWindow1(int[] nums, int k) {
        int[] res={};
        if(nums==null || nums.length==0 || nums.length<k)
            return res;
        PriorityQueue<Integer> pq = new PriorityQueue((o1,o2)->{
            Integer i1 = (Integer)o1;
            Integer i2 = (Integer)o2;
            return -Integer.compare(i1,i2);
        });
        res = new int[nums.length-k+1];
        int idx=0;

        for(int i=0;i<k;i++)
            pq.add(nums[i]);


        for(int i=k;i<nums.length;i++){
            int r=pq.peek();
            System.out.println("before: "+pq);
            pq.remove(nums[idx]);
            System.out.println("aftr: "+pq);
            res[idx++]=r;
            pq.add(nums[i]);
        }

        res[idx++]=pq.peek(); //missed adding the last element.
        return res;
    }
}