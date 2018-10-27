class Solution {
    public String solveEquation(String equation) {
        String[] eq = equation.split("=");
        int[] res1 = process(eq[0]);
        int[] res2 = process(eq[1]);
        res1[0]=res1[0]-res2[0];
        res1[1]=res2[1]-res1[1];

        if(res1[0]==0 && res1[1]==0)
            return "Infinite solutions";

        if(res1[0]==0)
            return "No solution";

        return "x="+(res1[1]/res1[0]);
    }


    public int[] process(String str){
        String[] tokens = str.split("(?=[+-])");
        int[] res = new int[2];
        for(String token: tokens){
            if(token.equals("+x")|| token.equals("x")) res[0]+=1;
            else if(token.contains("-x")) res[0]+=-1;
            else if(token.contains("x")) res[0]+=Integer.parseInt(token.substring(0,token.indexOf('x')));
            else res[1]+=Integer.parseInt(token);
        }
        return res;
    }
}