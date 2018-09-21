class PaintHouse {


    public int minCost(int[][] costs) {
        if(costs.length==0) return 0;
        int lastR = costs[0][0];
        int lastG = costs[0][1];
        int lastB = costs[0][2];
        for(int i=1; i<costs.length; i++){
            int curR = Math.min(lastG,lastB)+costs[i][0];
            int curG = Math.min(lastR,lastB)+costs[i][1];
            int curB = Math.min(lastR,lastG)+costs[i][2];
            lastR = curR;
            lastG = curG;
            lastB = curB;
        }
        return Math.min(Math.min(lastR,lastG),lastB);
    }





    //Didn't work :(
    public class Minimums{
        int firstMin;
        int secondMin;
        int firstMinIndex;
        int secondMinIndex;
        public  Minimums(int firstMin, int secondMin, int firstMinIndex, int secondMinIndex){
            this.firstMin = firstMin;
            this.secondMin = secondMin;
            this.firstMinIndex = firstMinIndex;
            this.secondMinIndex = secondMinIndex;
        }
    }


    public int minCost1(int[][] costs) {

        if(costs==null || costs.length==0)
            return 0;


        Minimums[] dp = new Minimums[costs.length];
        //costs.length should be atleast costs[0].length
        if(!(costs[0].length>2||costs.length<2))
            return -1;

        for(int i=0;i<costs.length;i++){
            int firstMin=Integer.MAX_VALUE;
            int secondMin = Integer.MAX_VALUE;
            int firstMinIndex = -1;
            int secondMinIndex = -1;
            for(int j=0;j<costs[0].length;j++){ //for each house various paints
                //compute firstmIn and secondmin
                if(costs[i][j]<=firstMin){
                    secondMinIndex = firstMinIndex;
                    secondMin = firstMin;
                    firstMin = costs[i][j];
                    firstMinIndex=j;
                }
                else if(secondMin > costs[i][j]){
                    secondMin = costs[i][j];
                    secondMinIndex = j;
                }
            }
            System.out.println(firstMin+","+secondMin);
            if(i==0)
                dp[i] = new Minimums(firstMin, secondMin, firstMinIndex,secondMinIndex);
            else{
                Minimums m = dp[i-1];
                if(m.firstMinIndex!=firstMinIndex){
                    dp[i]=new Minimums(m.firstMin+firstMin, m.secondMin+secondMin, firstMinIndex, secondMinIndex);
                }
                else{
                    int v1 = m.firstMin +secondMin;
                    int v2 = m.secondMin + firstMin;
                    if(v1<v2){
                        dp[i]=new Minimums(v1, v2, secondMinIndex, firstMinIndex);
                    }
                    else{
                        dp[i]= new Minimums(v2, v1, firstMinIndex, secondMinIndex);
                    }
                }
            }
        }
        return dp[costs.length-1].firstMin;
    }
}
