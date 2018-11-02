class Solution {
    public int minMeetingRooms(Interval[] intervals) {
        if(intervals==null || intervals.length<1) return 0;
        int count = 1;
        PriorityQueue<Integer> pq = new PriorityQueue();
        Arrays.sort(intervals, (i1,i2)-> Integer.compare(i1.start,i2.start));
        pq.add(intervals[0].end);
        for(int i=1;i<intervals.length;i++){
            if(pq.peek()<=intervals[i].start) pq.remove();
            else count++;
            pq.add(intervals[i].end);
        }
        return count;
    }
}