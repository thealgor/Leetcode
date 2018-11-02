class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        if(s==null || s.length()==0)
            return 0;

        Map<Character,Integer> map = new HashMap<>();
        int start=0, end=0, counter=0, max=Integer.MIN_VALUE;
        while(end<s.length()){
            char ec=s.charAt(end);
            map.put(ec, map.getOrDefault(ec,0)+1);
            if(map.size()>k) counter++;
            end++;

            while(counter>0){
                char sc = s.charAt(start);
                map.put(sc,map.get(sc)-1);

                if(map.get(sc)==0){
                    map.remove(sc);
                    counter--;
                }

                start++;
            }
            max = Math.max(max,end-start);
        }

        return max;
    }
}