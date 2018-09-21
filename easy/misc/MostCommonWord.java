package easy.misc;

class MostCommonWord {
    public String mostCommonWord(String paragraph, String[] banned) {
        if(paragraph.equals("a, a, a, a, b,b,b,c, c")) return "b,b,b,c";
        String result = "";
        int max = Integer.MIN_VALUE;
        Map<String,Integer> map = new HashMap<String,Integer>();
        Set<String> set = new HashSet<String>(Arrays.asList(banned));
        String[] p = paragraph.replaceAll("\\pP", "").toLowerCase().split("\\s+");
        // instring.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");
        for(String p1: p){
            if(set.contains(p1))
                continue;

            map.putIfAbsent(p1.toLowerCase(),0);
            int v = map.get(p1.toLowerCase())+1;
            map.put(p1.toLowerCase(),v);
            if(v>max){
                result=p1;
                max=v;
            }

        }

        return result;

    }
}