验证anagram。

public class Solution {
    public boolean isAnagram(String s, String t) {
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(s.length() != t.length()) return false;
        //如果是所有，就256个。
        int[] record = new int[26];
        for(int pos = 0; pos < s.length(); pos++){
            char cur = s.charAt(pos);
            record[(cur-'a')]++;
        }
        for(int pos = 0; pos < t.length(); pos++){
            char cur = t.charAt(pos);
            record[(cur-'a')]--;
            
        }
        for(int i : record){
            if(i != 0) return false;
        }
        return true;
    }
}

找Group的Anagram，先hash再排队。

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for(String str : strs){
            String curHash = getHash(str);
            if(!map.containsKey(curHash)){
                map.put(curHash, new ArrayList<>());
            }
            map.get(curHash).add(str);
        }
        Set<String> keys = map.keySet();
        for(String key : keys){
            Collections.sort(map.get(key));
            res.add(map.get(key));
        }
        return res;
    }
    private String getHash(String str){
        char[] strArr = str.toCharArray();
        Arrays.sort(strArr);
        return new String(strArr);
    }
}