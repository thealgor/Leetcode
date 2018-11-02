/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public boolean canAttendMeetings(Interval[] intervals) {
        //forgot to write comparator. Didn't realize I can write comparator for Arrays.sort as well :(
        Arrays.sort(intervals, (i1,i2) -> Integer.compare(i1.start,i2.start));
        for(int i=0;i<intervals.length-1;i++){
            if(intervals[i].end > intervals[i+1].start) return false;
        }
        return true;
    }
}