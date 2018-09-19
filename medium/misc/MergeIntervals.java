package medium.misc;

class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {

        List<Interval> result = new ArrayList<Interval>();
        if(intervals.size()==0)
            return result;

        intervals.sort((i1,i2)->(i1.start!=i2.start)?Integer.compare(i1.start,i2.start):Integer.compare(i1.end,i2.end));

        int start = intervals.get(0).start;
        int end = intervals.get(0).end;

        for(int i=1;i<intervals.size();i++){
            int newStart = intervals.get(i).start;
            int newEnd = intervals.get(i).end;

            if(newStart<=end){ //overlap
                if(newEnd>end)
                    end=newEnd;
            }
            else{
                result.add(new Interval(start,end));
                start=newStart;
                end=newEnd;
            }
        }

        result.add(new Interval(start,end));
        return result;


    }
}
