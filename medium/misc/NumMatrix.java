package medium.misc;

class NumMatrix {

    int[][] m;

    public NumMatrix(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)
            return;

        int rows = matrix.length;
        int cols = matrix[0].length;



        this.m= new int[rows][cols];


        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(j==0){
                    m[i][0]=matrix[i][0];
                    continue;
                }

                m[i][j]=m[i][j-1]+matrix[i][j];
            }
        }




    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1;i<=row2;i++){
            if(col1==0){
                sum+=m[i][col2];
                continue;
            }

            sum+=m[i][col2]-m[i][col1-1];
        }
        return sum;
    }
}


