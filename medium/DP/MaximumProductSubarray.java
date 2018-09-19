package medium.DP;

class MaximumProductSubarray {
    public int maxProduct1(int[] nums) {
        int n=nums.length;
        int[][] dp = new int[n][n];
        int max = Integer.MIN_VALUE;

        if(n==0)
            return 0;

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(i>j)
                    continue;
                if(i==j)
                    dp[i][j]=nums[i];
                else
                    dp[i][j]=dp[i][j-1]*nums[j];
                max=Math.max(dp[i][j],max);
            }
        }
        return max;
    }


    //O(n) solution
    public int maxProduct(int[] nums) {
        int globalMax = nums[0];

        int iMax = 1;
        int iMin = 1;

        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);

            if(nums[i]<0){
                int temp = iMax;
                iMax = iMin;
                iMin=temp;
            }


            iMax = Math.max(nums[i],iMax*nums[i]);
            iMin = Math.min(nums[i],iMin*nums[i]);


            globalMax = Math.max(globalMax,iMax);

        }
        return globalMax;

    }
}


class Solution {

    //11:22

    Map<String, List<String>> adj;
    Map<String, Integer> ladder;
    List<List<String>> results;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        adj = new HashMap<String, List<String>>();
        ladder = new HashMap<String, Integer>();
        Queue<String> q = new LinkedList<String>();
        results = new ArrayList<List<String>>();

        q.add(beginWord);

        ladder.put(beginWord,0);
        for(String s: wordList)
            ladder.put(s,Integer.MAX_VALUE);
        ladder.put(endWord,Integer.MAX_VALUE);

        while(!q.isEmpty()){
            String s = q.poll();
            int step = ladder.get(s)+1;
            StringBuilder sb = new StringBuilder(s);
            for(int i=0;i<sb.length();i++){
                for(char j='a';j<='z';j++){
                    sb.setCharAt(i,j);
                    String newWord = sb.toString();

                    if(ladder.containsKey(newWord)){
                        if(ladder.get(newWord)<step)
                            continue;
                        else if(ladder.get(newWord)>step){
                            ladder.put(newWord,step);
                            q.add(newWord);
                        }

                        //create adjacency matrix
                        adj.putIfAbsent(newWord,new ArrayList<String>());
                        adj.put(newWord,adj.get(newWord).add(s));

                    }

                    if(newWord.equals(endWord))
                        min=step;



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

        for(String word: adj.get(end)){
            list.add(word,start,result);
        }
        list.remove(0);

    }






}