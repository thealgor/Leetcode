class Solution {
    public List<List<String>> groupStringss(String[] strings) {
        Set<String> words = new HashSet();
        Set<String> solved = new HashSet();
        Map<String,List<String>> map = new HashMap();
        for(String word: strings)
            words.add(word);

        for(String word: strings){
            //if(solved.contains(word)&&!map.containsKey(word)) continue;

            solved.add(word);
            //map.computeIfAbsent(word, x->new ArrayList()).add(word);
            char[] cs = word.toCharArray();
            int offset = word.charAt(0)-'a';
            for(int i=1;i<=26;i++){
                String result = "";
                StringBuilder sb = new StringBuilder();
                for(char c: cs){
                    int v = (c-offset+i)%26;
                    char ch = (char)('a'+v);
                    sb.append(ch);
                }
                result = new String(sb);
                if (!map.containsKey(word)) {
                    List<String> list = new ArrayList<String>();
                    map.put(word, list);
                }
                map.get(word).add(result);
            }
        }

        List<List<String>> r = new ArrayList<List<String>>();
        map.forEach((k,v)-> r.add(v));

        return r;


    }


    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> result = new ArrayList<List<String>>();
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strings) {
            int offset = str.charAt(0) - 'a'; //say your character is 'a' 'a'-'a' - offset is zero.reducing everything to 'a' 'ab' 'abc'..
            String key = "";
            //za
            for (int i = 0; i < str.length(); i++) {
                char c = (char) (str.charAt(i) - offset);
                System.out.println(c);
                if (c < 'a') {
                    c += 26;
                }
                key += c;
            }

            //System.out.println(key);
            if (!map.containsKey(key)) {
                List<String> list = new ArrayList<String>();
                map.put(key, list);
            }
            map.get(key).add(str);
        }
        result.addAll(map.values());
        return result;
    }




}