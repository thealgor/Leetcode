class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<Character> cSet = new HashSet<Character>();
        Set<String> words = new HashSet<String>();
        Set<String> visited = new HashSet<String>();

        if(wordList.size()<=0)
            return -1;

        if(beginWord.equals(endWord))
            return 0;

        int strLen = wordList.get(0).length();
        for(String str: wordList){
            for(int i=0;i<strLen;i++)
                if(!cSet.contains(str.charAt(i)))
                    cSet.add(str.charAt(i));
        }

        for(String str: wordList){
            if(!words.contains(str))
                words.add(str);
        }

        Queue<String> q = new LinkedList<String>();
        q.add(beginWord);
        q.add(null);
        int depth = 1;
        while(!q.isEmpty()){
            String word = q.remove();

            if(word==null){
                depth++;

                if(q.isEmpty())
                    return 0;

                q.add(null);
                continue;
            }


            for(Character c: cSet){
                for(int i=0;i<strLen;i++){
                    if(word.charAt(i)==c)
                        continue;

                    String newString = word.substring(0,i)+c+word.substring(i+1);
                    if(newString.equals(endWord))
                        return depth+1;

                    if(words.contains(newString)&&!visited.contains(newString)){
                        q.add(newString);
                        visited.add(newString);
                    }

                }
            }



        }


        return -1;




    }
}