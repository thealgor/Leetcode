class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        Map<Character,Integer> map = new HashMap<>();
        int start = 0, end = 0, max = Integer.MIN_VALUE, counter=0;
        while(end<s.length()){
            char ec = s.charAt(end);
            map.put(ec,map.getOrDefault(ec,0)+1);
            if(map.get(ec)>1) counter++;
            end++;
            while(counter>0){
                char sc = s.charAt(start);
                if(map.containsKey(sc)){
                    map.put(sc,map.get(sc)-1);
                    if(map.get(sc)==1){
                        counter--;
                    }
                }
                start++;
            }
            max = Math.max(max, end-start); //missed it important
        }
        return max;
    }
}