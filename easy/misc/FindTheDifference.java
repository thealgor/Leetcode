package misc;

class FindTheDifference {
    public char findTheDifference(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(s2);
        for(int i=0;i<s1.length;i++){
            if(s1[i]!=s2[i])
                return s2[i];
        }
        return s2[s2.length-1];
    }
}