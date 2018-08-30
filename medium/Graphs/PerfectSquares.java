class PerfectSquares {
    public int numSquares(int n) {
        if(n<=0)
            return 0;
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0]=0; dp[1]=1;
        for(int i=2;i<=n;i++){
            int min = dp[i];
            for(int j=1;j<i;j++){
                //solution1
                if((i-j*j)>=0){
                    min=Math.min((dp[i-(j*j)]+1),min);
                    dp[i]=min;


                    //solution2
                    //dp[i]=Math.min(dp[i],Math.min((dp[i-j]+dp[j]), isPerfectSquare(i)?1:Integer.MAX_VALUE));

                }
                else
                    break;
            }
        }

        return dp[n];
    }

    /*public boolean isPerfectSquare(int n){

        double s = Math.sqrt(n);
        double f = Math.floor(s);
        double res = s-f;
        return (res==0.0)?true:false;
    }
    */


    //using BFS. Check how you are doing level order traversal. INstead of using null like we do to calculate depth. Interesting Solutionå

    public int numSquares1(int n) {

        ArrayDeque<Integer> queue = new ArrayDeque<Integer>();
        queue.add(n);
        int depth = 1, m = 1, tmp = 0;

        while(true){
            if(m == 0){
                depth++;
                m = tmp;
                tmp = 0;
            }

            int cur = queue.remove();
            m--;

            int l = (int) Math.sqrt(cur);
            for(int i=l; i>0; i--){
                int sq = i*i;
                int delta = cur - sq;
                if(delta == 0)
                    return depth;
                queue.add(delta);
                tmp++;
            }
        }
    }

}