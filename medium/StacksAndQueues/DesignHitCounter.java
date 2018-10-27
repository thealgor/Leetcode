class HitCounter {

    int[] times;
    int[] hits;
    /** Initialize your data structure here. */
    public HitCounter() {
        times = new int[300];
        hits = new int[300];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int index = timestamp%300;
        if(times[index]!=timestamp){
            times[index]=timestamp;
            hits[index]=1;
        }
        else
            hits[index]+=1;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int total = 0;
        for(int i=0;i<300;i++){
            if(timestamp-times[i]<300)
                total+=hits[i];
        }

        return total;
    }
}

/*
* if huge amount of hits happened at the same timestamp, this solution will takes too much memory since each element in queue is a single hit. It's better to map timestamp to the number of hits at this timestamp.
* If the size of hits getting larger and larger, this solution is inefficient;

list size will double once size hits a limit. A scalable problem will become more and more obvious.
worst case is that for everyHits happened after 5 mins, it will have to traverse the list from beginning to end; if LEN is n for every 5 mins, then the operation is linear. For read-heavy request, this is unacceptable.
*/

public class HitCounter1 {
    Queue<Integer> q = null;
    /** Initialize your data structure here. */
    public HitCounter1() {
        q = new LinkedList<Integer>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        q.offer(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while(!q.isEmpty() && timestamp - q.peek() >= 300) {
            q.poll();
        }
        return q.size();
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */