package easy.misc;

class JewelsAndStones {
    public int numJewelsInStones(String J, String S) {
        Set<Character> set = new HashSet<Character>();
        for(int i=0;i<J.length();i++)
            set.add(J.charAt(i));
        int count = 0;
        for(int i=0;i<S.length();i++){
            if(set.contains(S.charAt(i)))
                count++;
        }
        return count;
    }
}
