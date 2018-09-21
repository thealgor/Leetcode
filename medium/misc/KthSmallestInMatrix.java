package medium.misc;

class KthSmallestInMatrix {
    public int kthSmallestPQ(int[][] matrix, int k) {
        //1. max heap and return the top element after removing and replacing if you find a smaller element. O(n2 logk).
        //2. min heap but smaller solution O(klogn) or O(n)

        if(matrix.length==0)
            return -1;

        PriorityQueue<Tuple> pq = new PriorityQueue<Tuple>();
        for(int i=0;i<matrix.length;i++)
            pq.add(new Tuple(0,i,matrix[0][i]));

        for(int i=0;i<k-1;i++){
            Tuple t = pq.poll();
            if(t.x==matrix.length-1) continue;
            pq.add(new Tuple(t.x+1,t.y,matrix[t.x+1][t.y]));
        }

        return pq.poll().val;

    }

    public class Tuple implements Comparable<Tuple>{
        int x,y,val;
        public Tuple(int x, int y, int val){
            this.x=x;
            this.y=y;
            this.val=val;
        }

        @Override
        public int compareTo(Tuple that){
            return this.val - that.val;
        }
    }

    //search space - index or range. For this problem it is range. check notes.
    //binary search. Are k elements less than mid if not increase lo and eventually mid.
    //wonderful solution.
    public int kthSmallest(int[][] matrix, int k) {
        int lo = matrix[0][0], hi = matrix[matrix.length-1][matrix[0].length-1];

        while(lo<hi){
            int mid = lo + (hi-lo)/2;
            int j=matrix[0].length-1, count=0;
            for(int i=0;i<matrix.length;i++){
                while(j>=0 && matrix[i][j]>mid)j--;
                count+=(j+1);
            }
            if(count<k) lo=mid+1;
            else
                hi=mid;
        }
        return lo;
    }




}