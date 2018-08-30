class Search2DMatrix2 {
    public boolean searchMatrix(int[][] matrix, int target) {



        if(matrix.length==0 || matrix[0].length==0)
            return false;

        int m=matrix.length;
        int n=matrix[0].length;

        int lo=0, hi=n-1;

        while(lo<m && hi>=0){
            if(matrix[lo][hi]<target)
                lo++;
            else if(matrix[lo][hi]>target)
                hi--;
            else if(matrix[lo][hi]==target)
                return true;
        }
        return false;

    }
}