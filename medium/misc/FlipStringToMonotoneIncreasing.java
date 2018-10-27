class Solution {
    public int minFlipsMonoIncr(String S) {
        int[] left = new int[S.length()+1];
        int[] right = new int[S.length()+1];
        int count=0;
        for(int i=0;i<S.length();i++){
            if(S.charAt(i)=='1')
                count++;
            left[i+1]=count;
        }

        count = 0;
        for(int j=S.length();j>0;j--){
            if(S.charAt(j-1)=='0')
                count++;
            right[j-1]=count;
        }


        int minFlips = Integer.MAX_VALUE;

        for(int i=0;i<S.length()+1;i++){
            minFlips = Math.min(left[i]+right[i], minFlips);
        }

        // if(minFlips>left[S.length()-1])
        //     minFlips = left[S.length()-1];
        // if(minFlips> right[0])
        //     minFlips=right[0];
        return minFlips;

    }
}