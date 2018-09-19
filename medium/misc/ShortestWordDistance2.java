package medium.misc;

class ShortestWordDistance2 {


    Map<String,List<Integer>> map = new HashMap<String,List<Integer>>();
    public WordDistance(String[] words) {
        int i=0;
        for(String word: words){
            map.putIfAbsent(word,new ArrayList<Integer>());
            map.get(word).add(i);
            i++;
        }

    }

    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        List<Integer> l1 =  map.get(word1);
        List<Integer> l2 =  map.get(word2);
        for(int i=0, j=0;i<l1.size() && j<l2.size();){
            int index1 = l1.get(i);
            int index2 = l2.get(j);
            min = Math.min(Math.abs((index2-index1)),min);
            if(index1<index2)
                i++;
            else
                j++;

        }
        return min;
    }
}

class WordDistance {

    private class WordPair{
        String word1;
        String word2;
        public WordPair(String word1, String word2){
            this.word1=word1;
            this.word2=word2;
        }

        @Override
        public boolean equals(Object obj){
            WordPair w = (WordPair)obj;
            boolean val = ((this.word1.equals(w.word1))&&(this.word2.equals(w.word2)));
            return val;
        }

        @Override
        public int hashCode(){
            final int prime=31;
            int result = 1;
            result = result*prime + (word1==null?0:word1.hashCode());
            result = result*prime + (word2==null?0:word2.hashCode());
            return result;

        }


    }

    Map<WordPair,Integer> map = new HashMap<WordPair,Integer>();
    public WordDistance(String[] words) {
        for(int i=0;i<words.length;i++){
            for(int j=i;j<words.length;j++){
                if(i==j)
                    continue;

                int distance = j-i;
                WordPair w1= new WordPair(words[i],words[j]);
                WordPair w2 = new WordPair(words[j],words[i]);
                map.putIfAbsent(w1,distance);
                map.put(w1,Math.min(map.get(w1),distance));
                map.putIfAbsent(w2,distance);
                map.put(w2,Math.min(map.get(w2),distance));
            }
        }
    }

    public int shortest(String word1, String word2) {
        WordPair w1 = new WordPair(word1,word2);
        WordPair w2 = new WordPair(word2,word1);
        int min = Integer.MAX_VALUE;

        if(map.containsKey(w1)){
            min = Math.min(map.get(w1),min);
        }
        if(map.containsKey(w2)){
            min = Math.min(map.get(w2),min);
        }

        if(min==Integer.MAX_VALUE)
            return -1;
        else
            return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(words);
 * int param_1 = obj.shortest(word1,word2);