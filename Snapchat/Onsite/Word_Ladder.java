出II我就傻逼了，可以到时候先说思路，然后再搞code。

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(wordList == null) return 0;
        wordList.add(beginWord);
        wordList.add(endWord);
        
        Queue<String> queue = new LinkedList<String>();
        queue.offer(beginWord);
        int level = 1;
        Set<String> visited = new HashSet<String>();
        visited.add(beginWord);
        
        while(!queue.isEmpty()){
            level++;
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String cur = queue.poll();
                for(String nextWord : getNextWords(cur, wordList)){
                    if(nextWord.equals(endWord)){
                        return level;
                    }
                    if(visited.contains(nextWord)){
                        continue;
                    }
                    visited.add(nextWord);
                    queue.offer(nextWord);
                }

            }
        }
        return 0;
    }
    public ArrayList<String> getNextWords(String cur, Set<String> wordList){
        ArrayList<String> result = new ArrayList<>();
        for(int i = 0; i < cur.length(); i++){
            for(char c = 'a'; c <= 'z'; c++){
                if(c == cur.charAt(i)) continue;
                String afterRp = replace(cur, i, c);
                if(wordList.contains(afterRp)){
                    result.add(afterRp);
                }
            }
        }
        return result;
    }
    public String replace(String word, int i, char c){
        char[] temp = word.toCharArray();
        temp[i] = c;
        return new String(temp);
    }
}