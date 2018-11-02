class Solution {


    /*
     * clockwise rotate
     * first reverse up to down, then swap the symmetry
     * 1 2 3     7 8 9     7 4 1
     * 4 5 6  => 4 5 6  => 8 5 2
     * 7 8 9     1 2 3     9 6 3
     */

    /*
     * anticlockwise rotate
     * first reverse left to right, then swap the symmetry
     * 1 2 3     3 2 1     3 6 9
     * 4 5 6  => 6 5 4  => 2 5 8
     * 7 8 9     9 8 7     1 4 7
     */

    public void rotate(int[][] matrix) {
        //m,n are same in an image

        int m = matrix.length;


        //bottom row to the top
        for(int i=0;i<m/2;i++){
            for(int j=0;j<m;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[m-1-i][j];
                matrix[m-1-i][j]=temp;
            }
        }

        //swap symmetry
        for(int i=0;i<m;i++){
            for(int j=0;j<i;j++){ //so that you won't do it twice i j and again go to ji and swap this would lead to leaving the data at the start stage
                int temp = matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;

            }
        }


    }


    public void rotateAlternative(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i=0;i<m/2;i++){
            for(int j=i;j<m-1-i;j++){
                int temp = matrix[i][j];
                matrix[i][j]=matrix[m-1-j][i];
                matrix[m-1-j][i]  = matrix[m-1-i][n-1-j];
                matrix[m-1-i][n-1-j]=matrix[j][n-1-i];
                matrix[j][n-1-i]=temp;
            }
        }
    }
}