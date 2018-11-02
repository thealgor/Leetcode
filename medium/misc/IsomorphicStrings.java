class Solution {


    public boolean isIsomorphic(String s, String t){
        int[] m1 = new int[256];
        int[] m2 = new int[256];
        for(int i=0;i<s.length();i++){
            if(m1[s.charAt(i)]!=m2[t.charAt(i)]) return false;
            m1[s.charAt(i)]=i+1;
            m2[t.charAt(i)]=i+1;
        }
        return true;
    }



    public boolean isIsomorphicbb(String s, String t) {
        if(s.isEmpty() || s==null)
            return true;


        Map<Character,Character> map = new HashMap();

        for(int i=0;i<s.length();i++){
            char s1 = s.charAt(i);
            char s2 = t.charAt(i);

            char c = map.computeIfAbsent(s1,x->s2);
            if(c!=s2) return false;
        }
        return true;

    }



    //didn't work :( check the case below.
    //"aba"
//"baa"

//failed this use case.

    public boolean isIsomorphicaa(String s, String t) {
        if(s.isEmpty() || s==null)
            return true;


        Map<Character,Integer> map1 = new HashMap();
        Map<Character,Integer> map2 = new HashMap();
        char prev1=' ';
        char prev2=' ';

        boolean isContinguous1 = false, isContiguous2 = false;
        for(int i=0;i<s.length();i++){
            char s1 = s.charAt(i);
            char s2 = t.charAt(i);

            if((prev1==s1 && prev2!=s2) || (prev2==s2 && prev1!=s1) )
                return false;


            int v1 = map1.computeIfAbsent(s1,x->0)+1;
            int v2 = map2.computeIfAbsent(s2,x->0)+1;

            if(v1==v2){
                map1.put(s1,v1);
                map2.put(s2,v2);
            }
            else
                return false;
            prev1=s1;
            prev2=s2;
        }
        return true;

    }
}