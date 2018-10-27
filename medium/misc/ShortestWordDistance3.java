class Solution1 {

    public int shortestWordDistance(String[] words, String word1, String word2) {
        Map<String, List<Integer>> map = new HashMap();

        for(int i=0;i<words.length;i++){
            map.computeIfAbsent(words[i],x->new ArrayList<Integer>()).add(i);
        }

        List list1 = map.get(word1);
        List list2 = map.get(word2);
        return findShortestDistance(list1, list2);

    }


    public int findShortestDistance1(List<Integer> list1, List<Integer> list2){
        int min = Integer.MAX_VALUE;
        for(int i=0;i<list1.size();i++){
            for(int j=0;j<list2.size();j++){
                if(list1.equals(list2)){
                    if(i==j)
                        continue;
                }
                min = Math.min(min,Math.abs(list2.get(j)-list1.get(i)));
            }
        }

        return min;
    }


    public int findShortestDistance(List<Integer> list1, List<Integer> list2){
        int min = Integer.MAX_VALUE;
        int i=0,j=0;
        while(i<list1.size() && j<list2.size()){
            System.out.println(list1+","+list2);
            if(list1.equals(list2)){
                if(i==j){
                    j++;
                    continue;
                }
            }

            int diff = list1.get(i) - list2.get(j);

            min = Math.min(min, Math.abs(diff));
            if(diff<0){
                i++;
                continue;
            }
            else{
                j++;
            }
        }

        if(list1.equals(list2))
            return min;

        while(i<list1.size()){
            int diff = list1.get(i) - list2.get(list2.size()-1);
            min = Math.min(min, Math.abs(diff));
            i++;
        }


        while(j<list2.size()){
            int diff = list1.get(list1.size()-1) - list2.get(j);
            min = Math.min(min, Math.abs(diff));
            j++;
        }

        return min;
    }

}


public class Solution {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index = -1;
        int min = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1 && (word1.equals(word2) || !words[index].equals(words[i]))) {
                    min = Math.min(i - index, min);
                }
                index = i;
            }
        }
        return min;
    }
}


class ShortestWord1 {
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index = -1;
        int min = words.length;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1) || words[i].equals(word2)) {
                if (index != -1 && !words[index].equals(words[i])) {
                    min = Math.min(i - index, min);
                }
                index = i;
            }
        }
        return min;
    }
}