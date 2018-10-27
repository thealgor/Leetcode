class Solution {

    public String longestCommonPrefix2(String[] strs) {
        if(strs==null || strs.length==0)
            return "";

        String prefix = strs[0];
        for(int k=1;k<strs.length;k++){
            String str2 = strs[k];
            int i=0, j=0;
            while(i<prefix.length() && j<str2.length()){
                if(prefix.charAt(i)==str2.charAt(j)){
                    i++;
                    j++;
                }
                else
                    break;
            }
            prefix = prefix.substring(0,i);

        }
        return prefix;
    }

    //better code
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String pre = strs[0];
        for (int i = 1; i < strs.length; i++)
            while(strs[i].indexOf(pre) != 0)
                pre = pre.substring(0,pre.length()-1);
        return pre;
    }

    //sort and compare only first and last elements of the array.
    /*
     * A correct analysis of using MergeSort to sort strings is actually very simple. We know that MergeSort does Θ(\U0001d45blog\U0001d45b) comparisons to sort \U0001d45b objects. In our case, the objects are \U0001d45b-character strings, hence each comparison takes \U0001d442(\U0001d45b) time. Thus, the entire algorithm runs in \U0001d442(\U0001d45b2log\U0001d45b). In the worst case this solution is worse than the one with the trie by a factor of log\U0001d45b.
     */


    public String longestCommonPrefix4(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs!= null && strs.length > 0){

            Arrays.sort(strs);

            char [] a = strs[0].toCharArray();
            char [] b = strs[strs.length-1].toCharArray();

            for (int i = 0; i < a.length; i ++){
                if (b.length > i && b[i] == a[i]){
                    result.append(b[i]);
                }
                else {
                    return result.toString();
                }
            }

        }
        return result.toString();
    }


    //vertical scanning more efficient with same time complexity.
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length() ; i++){
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j ++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }
}