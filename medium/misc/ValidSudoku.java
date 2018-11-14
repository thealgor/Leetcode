package medium.misc;

class ValidSudoku {
    
    public boolean isValidSudoku(char[][] board) {
    for(int i = 0; i<9; i++){
        HashSet<Character> rows = new HashSet<Character>();
        HashSet<Character> columns = new HashSet<Character>();
        HashSet<Character> cube = new HashSet<Character>();
        for (int j = 0; j < 9;j++){
            if(board[i][j]!='.' && !rows.add(board[i][j]))
                return false;
            if(board[j][i]!='.' && !columns.add(board[j][i]))
                return false;
            int RowIndex = 3*(i/3);
            int ColIndex = 3*(i%3);
            if(board[RowIndex + j/3][ColIndex + j%3]!='.' && !cube.add(board[RowIndex + j/3][ColIndex + j%3]))
                return false;
        }
    }
    return true;
}
    
    
    
     public boolean isValidSudokuBetterSolution(char[][] board) {
        Set seen = new HashSet();
        for (int i=0; i<9; ++i) {
            for (int j=0; j<9; ++j) {
                char number = board[i][j];
                if (number != '.')
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column " + j) ||
                            !seen.add(number + " in block " + i/3 + "-" + j/3))
                        return false;
            }
        }
        return true;
    }
    
    
    
    
    public boolean isValidSudoku(char[][] board) {
        Set<Character> set;

        if(board==null || board[0]==null)
            return false;

        int m = board.length;
        int n = board[0].length;

        if(m!=n || m!=9 || n!=9)
            return false;

        //check all rows
        for(int i=0;i<board.length;i++){
            set = new HashSet<Character>();
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.') continue;
                //System.out.println(set);
                //System.out.println(board[i][j]);

                if(!isValid(board,i,j) || set.contains(board[i][j]))
                    return false;
                else
                    set.add(board[i][j]);
            }
        }

        //System.out.println("1");
        //check all columns
        for(int i=0;i<board[0].length;i++){
            set = new HashSet<Character>();
            for(int j=0;j<board.length;j++){
                if(board[j][i]=='.') continue;
                if(!isValid(board,j,i) ||set.contains(board[j][i]))
                    return false;
                else
                    set.add(board[j][i]);
            }
        }

        //System.out.println("2");
        for(int l=0;l<9;l+=3){
            for(int k=0;k<9;k+=3){
                set = new HashSet<Character>();
                for(int i=k;i<k+3;i++){
                    for(int j=l;j<l+3;j++){
                        if(board[i][j]=='.') continue;
                        if(!isValid(board,i,j) || set.contains(board[i][j]))
                            return false;
                        else
                            set.add(board[i][j]);
                    }
                }

            }

        }

        // System.out.println("3");

        return true;

    }

    boolean isValid(char[][] board, int i, int j){
        if((board[i][j]>='0' && board[i][j]<='9' )|| board[i][j]=='.')
            return true;

        return false;
    }


   


}
