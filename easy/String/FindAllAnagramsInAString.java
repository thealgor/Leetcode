class Solution {

    public List<Integer> findAnagrams(String s, String p) {
        int[] counts = new int[26];
        for(int i=0;i<p.length();i++){
            counts[p.charAt(i)-'a']++;
        }

        List<Integer> result = new ArrayList<Integer>();
        int k = p.length();

        for(int i=0;i<s.length()-k+1;i++){
            int[] c = counts.clone();
            String t = s.substring(i,i+k);
            for(int j=0;j<t.length();j++){
                c[t.charAt(j)-'a']--;
            }
            boolean isAnagram =true;
            for(int j=0;j<c.length;j++){
                if(c[j]!=0){
                    isAnagram = false;
                    break;
                }
            }

            if(isAnagram)
                result.add(i);
        }

        return result;



    }




    public List<Integer> findAnagramsTLE(String s, String p) {
        char[] cp = p.toCharArray();
        Arrays.sort(cp);
        String p1 = new String(cp);
        int k = p1.length();
        List<Integer> result = new ArrayList<Integer>();
        for(int i=0;i<s.length()-k+1;i++){
            String s1 = s.substring(i,i+k);
            char[] cs1 = s1.toCharArray();
            Arrays.sort(cs1);
            String s2 = new String(cs1);
            if(s2.equals(p1))
                result.add(i);
        }

        return result;

    }
}