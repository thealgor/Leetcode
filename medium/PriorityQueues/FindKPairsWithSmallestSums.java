class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Tuple> pq = new PriorityQueue();
        List<int[]> res = new ArrayList();
        if(nums1==null || nums1.length==0 || nums2==null || nums2.length==0) return res;
        int m = nums1.length,n=nums2.length;
        for(int i=0;i<Math.min(n,k);i++) pq.add(new Tuple(0,i,nums1[0]+nums2[i]));
        for(int i=0;i<Math.min(k,m*n);i++){
            Tuple t = pq.poll();
            res.add(new int[]{nums1[t.x],nums2[t.y]});
            if(t.x==m-1) continue;
            pq.add(new Tuple(t.x+1,t.y,nums1[t.x+1]+nums2[t.y]));
        }
        return res;
    }

    class Tuple implements Comparable<Tuple>{
        int x;
        int y;
        int value;
        public Tuple(int x, int y, int value){
            this.x=x;
            this.y=y;
            this.value=value;
        }

        @Override
        public int compareTo(Tuple that){
            return this.value-that.value;
        }
    }
}