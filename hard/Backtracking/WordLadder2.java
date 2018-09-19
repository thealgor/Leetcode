package hard.Backtracking;

class WordLadder2 {

    //11:22

    Map<String, List<String>> adj;
    Map<String, Integer> ladder;
    List<List<String>> results;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        adj = new HashMap<String, List<String>>();
        ladder = new HashMap<String, Integer>();
        Queue<String> q = new LinkedList<String>();
        results = new ArrayList<List<String>>();
        int min = Integer.MAX_VALUE;

        q.add(beginWord);

        ladder.put(beginWord,0);
        for(String s: wordList)
            ladder.put(s,Integer.MAX_VALUE);
        //ladder.put(endWord,Integer.MAX_VALUE);

        while(!q.isEmpty()){
            String s = q.poll();
            int step = ladder.get(s)+1;
            for(int i=0;i<s.length();i++){
                StringBuilder sb = new StringBuilder(s);
                for(char j='a';j<='z';j++){
                    sb.setCharAt(i,j);
                    String newWord = sb.toString();
                    //System.out.println(newWord);
                    if(newWord.equals(s)) continue;
                    if(ladder.containsKey(newWord)){
                        //System.out.println(newWord);
                        if(ladder.get(newWord)<step)
                            continue;
                        else if(ladder.get(newWord)>step){

                            ladder.put(newWord,step);
                            q.add(newWord);

                        }

                        //create adjacency matrix
                        adj.putIfAbsent(newWord, new ArrayList<String>());
                        adj.get(newWord).add(s);

                    }

                    if(newWord.equals(endWord)){
                        min=step;
                    }



                }
            }
        }

        LinkedList<String> list = new LinkedList<String>();
        backtrackDFS(endWord,beginWord,list);
        return results;

    }

    public void backtrackDFS(String end, String start, LinkedList<String> list){


        if(end==start){
            list.add(0,start);
            results.add(new ArrayList(list));
            list.remove(0);
            return;
        }


        list.add(0,end);
        if(adj.get(end)!=null){
            for(String word: adj.get(end)){
                backtrackDFS(word,start,list);
            }

        }

        list.remove(0);

    }





