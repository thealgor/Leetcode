package medium.misc;

class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        List<List<String>> result = new ArrayList<List<String>>();

        for(String str: strs){
            String sorted = sort(str);
            map.putIfAbsent(sorted,new ArrayList<String>());
            map.get(sorted).add(str);
        }

        for(Map.Entry<String,List<String>> entry: map.entrySet()){
            List<String> list = entry.getValue();
            result.add(list);
        }
        return result;
    }


    public String sort(String str){
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }
}