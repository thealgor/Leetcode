class Solution {
    public int minFallingPathSum(int[][] A) {

        if(A==null || A.length==0)
            return 0;

        int[][] dp = new int[A.length][A[0].length];
        int m = A.length, n=A[0].length;


        for(int i=0;i<n;i++){
            dp[m-1][i]=A[m-1][i];
        }

        for(int i=m-2;i>=0;i--){
            for(int j=0;j<n;j++){
                //System.out.println(i+","+j);
                int min = Integer.MAX_VALUE;
                if(j<n-1)
                    min = Math.min(dp[i+1][j+1],min);
                if(j>0)
                    min = Math.min(dp[i+1][j-1],min);
                min=Math.min(dp[i+1][j],min);

                dp[i][j]=A[i][j]+min;
            }
        }

//         for(int i=0;i<m;i++)
//             System.out.println(Arrays.toString(dp[i]));

        int min = Integer.MAX_VALUE;

        for(int i=0;i<n;i++)
            min = Math.min(dp[0][i],min);

        return min;

    }
}