package easy.misc;

class RomanToInteger {
    public int romanToInt(String s) {

        if(s==null || s.length()==0)
            return 0;

        Map<String,Integer> map = new HashMap<String,Integer>();

        map.put("IV",4);
        map.put("IX",9);
        map.put("XL",40);
        map.put("XC",90);
        map.put("CD",400);
        map.put("CM",900);
        map.put("I",1);
        map.put("X",10);
        map.put("V",5);
        map.put("L",50);
        map.put("C",100);
        map.put("D",500);
        map.put("M",1000);

        int result = 0;
        for(int i=0;i<s.length();i++){
            if(i!=s.length()-1){
                String s1 = s.substring(i,i+2);
                if(map.containsKey(s1)){
                    result += map.get(s1);
                    i++;
                }
                else{
                    result += map.get(s.substring(i,i+1));
                }
            }
            else{
                result+=map.get(Character.toString(s.charAt(i)));
            }
        }
        return result;

    }

}