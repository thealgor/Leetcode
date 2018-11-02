class Solution {
    public String minWindow(String s, String t) {

        String result = "";
        Map<Character,Integer> map = new HashMap<>();

        for(int i=0;i<t.length();i++){
            map.put(t.charAt(i),map.getOrDefault(t.charAt(i),0)+1);
        }


        int start=0, end=0, min=Integer.MAX_VALUE, counter=map.size();

        while(end<s.length()){
            char c = s.charAt(end);
            if(map.containsKey(c)){
                map.put(c,map.get(c)-1);
                if(map.get(c)==0) counter--;
            }
            end++;

            while(counter==0){

                char c1 = s.charAt(start);
                //System.out.println("inside counter: "+c1);
                if(map.containsKey(c1)){
                    map.put(c1, map.get(c1)+1);
                    if(map.get(c1)>0){
                        int len = end - start;
                        if(len<min){
                            result = s.substring(start,end);
                            min = len;
                            System.out.println(result);
                        }
                        counter++;
                    }
                }


                start++;
            }
        }

        return result;



    }
}