一堆interview的起始和终止，找最少meeting room使用数，需要输出如何安排的。
首先对interval排序，按照起始的时间呗。
然后加入Priority Queue里面，按照end排序，用容器来记录每个房间当前的end，index就是房间号了。
//我擦就输入个房间号就行。

class MeetingRoom{
	public List<Integer> meetingRoomSchedule(Interval[] intervals){
		List<Integer> eachRoomEnd = new ArrayList<>();
		List<Integer> result = new ArrayList<>();
		Arrays.sort(intervals, new Comparator<Interval>(){
			public int compare(Interval a, Interval b){
				return a.start - b.start;
			}
		});
		Queue<Interval> pq = new PriorityQueue<Interval>(new Comparator<Interval>(){
			public int compare(Interval a, Interval b){
				return a.end - b.end;
			}
		});
	}
	public static void main(String[] args) {
		
	}
}

class Interval{
	int start;
	int end;
	public Interval(int start, int end) {
		this.start = start;
		this.end = end;
	}
}