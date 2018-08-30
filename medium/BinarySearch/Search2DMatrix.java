class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {

        if(matrix.length<1)
            return false;
        int n = matrix.length;
        int m = matrix[0].length;

        int lo=0, hi=m*n-1;

        while(lo<=hi){
            int mid = lo + (hi-lo)/2;

            if(matrix[mid/m][mid%m]<target)
                lo=mid+1;
            else if(matrix[mid/m][mid%m]>target)
                hi=mid-1;
            else
                return true;
        }
        return false;

    }
}