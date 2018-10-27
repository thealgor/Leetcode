class MedianFinder {

    //Use Long to avoid overflow
    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    /** initialize your data structure here. */
    public MedianFinder() {
        // left = new PriorityQueue((o1,o2) -> {
        //     Integer i1 = (Integer)o1;
        //     Integer i2 = (Integer)o2;
        //     return -Integer.compare(i1,i2);
        // });
        left = new PriorityQueue(Collections.reverseOrder());
        right = new PriorityQueue();
    }

    public void addNum(int num) {
        right.add(num);
        left.add(right.poll());
        if(left.size()>right.size()){
            right.add(left.poll());
        }
    }

    public double findMedian() {
        return left.size()<right.size()? right.peek(): (left.peek()+right.peek())/2.0;
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */