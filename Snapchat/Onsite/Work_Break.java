比起OA，它需要输出1个valid的解就可以了。
感觉这样的话，dfs，能找到结尾就直接返回就可以了。
下面这段是OA的。

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        boolean[] canCut = new boolean[s.length()+1];
        canCut[0] = true;
        int len = getLength(wordDict);
        for(int i = 1; i <= s.length(); i++){
            for(int j = 1; j <= i && j <= len; j++){
                String cur = s.substring(i-j, i);
                if(canCut[i-j] && wordDict.contains(cur)){
                    canCut[i] = true;
                    break;
                }
            }
        }
        return canCut[s.length()];
    }
    public int getLength(Set<String> wordDict){
        int result = 0;
        for(String str : wordDict){
            result = Math.max(result, str.length());
        }
        return result;
    }
}