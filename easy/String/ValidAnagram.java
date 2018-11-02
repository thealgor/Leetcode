class Solution {
    public boolean isAnagram(String s, String t) {
        int[] count = new int[26];
        for(int i=0;i<s.length();i++)
            count[s.charAt(i)-'a']++;
        for(int j=0;j<t.length();j++)
            count[t.charAt(j)-'a']--;
        for(int i=0;i<count.length;i++)
            if(count[i]!=0) return false;
        return true;

    }
}