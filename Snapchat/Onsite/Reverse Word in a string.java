基本和follow up全出了，第二个要求是in-place的。

1.注意I里面可能有多个space，用" "断开的时候，跳过""的情况。
2.就是找到单词就可以，用prev来当做词头，遇到空格才更新。千万别忘了while里面要把变量++或者--。

public class Solution {
    public String reverseWords(String s) {
        String[] strArr = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i = strArr.length-1; i>= 0; i--){
            if(strArr[i].equals("")){
                continue;
            }
            sb.append(strArr[i]).append(" ");
        }
        return sb.length() == 0 ? "" : sb.toString().substring(0, sb.length()-1);
    }
}

follow up：
public class Solution {
    public void reverseWords(char[] s) {
        if(s == null || s.length == 0) return;
        helper(s, 0, s.length-1);
        int prev = 0;
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
                helper(s, prev, i-1);
                prev = i+1;
            }
        }
        helper(s, prev, s.length-1);
    }
    public void helper(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start++] = s[end];
            s[end--] = temp;
        }
    }
} 