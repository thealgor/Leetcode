
public class Solution {
    public List<Integer> findSubstring(String S, String[] L) {
        List<Integer> result = new ArrayList<Integer>();

        if(L.length==0 || S.length() < L[0].length()*L.length)
            return result;

        Map<String,Integer> map = new HashMap<String,Integer>();
        Map<String,Integer> cMap = new HashMap<>();
        for(String ls: L)
            map.put(ls,map.getOrDefault(ls,0)+1);

        int wl = L[0].length();
        int sl = S.length();
        int ls = L.length;


        for(int i=0;i<wl;i++){
            int start = i;
            int count = 0;

            for(int j=i;j+wl<=sl;j+=wl){ //start from first element and start from second and third(for three letter word and do jumps)
                String str = S.substring(j,j+wl);

                if(map.containsKey(str)){
                    if(map.containsKey(str))
                        cMap.put(str,cMap.getOrDefault(str,0)+1);

                    if(cMap.get(str)<=map.get(str)) count++;
                    //s = "barfoothefoobarman",
                    //words = ["foo","bar"]
                    //Say string is continuously barbarbarbar..remove the beginning ones.
                    while(cMap.get(str)>map.get(str)){ //remove the first repeated word and move the start
                        String tmp = S.substring(start,start+wl);
                        cMap.put(tmp,cMap.get(tmp)-1);
                        start+=wl;
                        if(cMap.get(tmp)<map.get(tmp)) count--;
                    }

                    if(count==ls){ //you found all the elements and move the start after adding the result and remove the first word.
                        result.add(start);
                        String tmp = S.substring(start, start+wl);
                        cMap.put(tmp, cMap.get(tmp)-1);
                        start+=wl;
                        count--;
                    }

                }
                else{
                    cMap.clear();
                    count=0;
                    start=j+wl;//doesn't contian so move start
                }
            }
            cMap.clear();
        }

        return result;
    }
}