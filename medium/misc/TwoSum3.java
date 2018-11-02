
//O(1) find  and O(n) add;
public class TwoSumss {
    Set<Integer> sum;
    Set<Integer> num;

    TwoSumss(){
        sum = new HashSet<Integer>();
        num = new HashSet<Integer>();
    }
    // Add the number to an internal data structure.
    public void add(int number) {
        if(num.contains(number)){
            sum.add(number * 2);
        }else{
            Iterator<Integer> iter = num.iterator();
            while(iter.hasNext()){
                sum.add(iter.next() + number);
            }
            num.add(number);
        }
    }

    // Find if there exists any pair of numbers which sum is equal to the value.
    public boolean find(int value) {
        return sum.contains(value);
    }
}






//O(n) find and O(1) add (other one got time limti)
class TwoSum {
    Map<Integer,Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        map = new HashMap();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(map.containsKey(number))
            map.put(number,2);
        else
            map.put(number,1);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            int diff = value-entry.getKey();
            if(map.containsKey(diff)){
                if(diff!=entry.getKey() || (map.get(diff)==2))
                    return true;
            }
        }


        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */