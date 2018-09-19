package easy.misc;

class ShortestWordDistance {
    public int shortestDistance(String[] words, String word1, String word2) {
        int count = 0;
        boolean found1=false;
        boolean found2=false;

        int min = Integer.MAX_VALUE;

        for(String word: words){
            if(found1||found2)
                count++;
            if(word1.equals(word)){
                if(found1==true){
                    count=0;
                }
                found1=true;
            }

            else if(word2.equals(word)){
                if(found2==true)
                    count=0;
                found2=true;

            }

            if(found1&&found2){
                min = Math.min(min,count);
                System.out.println(min);
                if(word1.equals(word))
                    found2=false;
                else
                    found1=false;
                count=0;
            }

        }
        return min;


    }
}