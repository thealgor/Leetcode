class Solution {

    //fails with space limit exceeded.
    public List<String> wordBreak2(String s, List<String> wordDict) {
        Set<String> wordDict1 = new HashSet(wordDict);
        LinkedList<String>[] dp = new LinkedList[s.length()+1];
        dp[0]=new LinkedList<String>();
        dp[0].add("");
        for(int i=1;i<s.length()+1;i++){
            LinkedList<String> list = new LinkedList();
            for(int j=0;j<i;j++){
                if(dp[j].size()>0 && wordDict1.contains(s.substring(j,i))){
                    for(String str: dp[j]){
                        str = str+(str==""?"":" ")+s.substring(j,i);
                        list.add(str);
                    }
                }
            }
            dp[i]=list;
        }
        return dp[s.length()];
    }


    //works fine with DFS
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> wordDict1 = new HashSet(wordDict);
        return DFS(s, wordDict1, new HashMap<String, LinkedList<String>>());
    }

    // DFS function returns an array including all substrings derived from s.
    List<String> DFS(String s, Set<String> wordDict, HashMap<String, LinkedList<String>>map) {
        if(map.containsKey(s))
            return map.get(s);
        LinkedList<String> list = new LinkedList<String>();
        if(s.length()==0){
            list.add("");
            return list;
        }

        for(String word: wordDict){
            if(s.startsWith(word)){

                List<String> strs = DFS(s.substring(word.length()),wordDict,map);
                for(String str: strs){
                    str = word + (str==""?"":" ")+str;
                    list.add(str);
                }

            }
        }
        map.put(s,list);
        return list;
    }


}