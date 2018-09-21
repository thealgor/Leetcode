package hard.Backtracking;

class NQueens {
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i=0;i<n;i++)
            Arrays.fill(board[i],'.');
        List<List<String>> result = new ArrayList<List<String>>();
        dfs(board,0,result);
        return result;
    }

    public void dfs(char[][] board, int colIndex,List<List<String>> result){

        if(colIndex==board.length){ // basically you reached n elements
            List<String> list = constructResult(board);
            result.add(list);
            return;
        }

        for(int i=0;i<board.length;i++){
            if(isValidPosition(board,i,colIndex)){
                board[i][colIndex]='Q';
                dfs(board,colIndex+1,result);
                board[i][colIndex]='.';
            }
        }
    }

    //go back and check if the position is valid wrt all the older Queens we already placed.
    public boolean isValidPosition(char[][] board, int x, int y){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<y;j++){
                if((board[i][j]=='Q') && (x+y==i+j||x+j==y+i||x==i)){ //1) equal to row 2) remaining two are diagonaols watch Tushar's video for more details
                    return false;
                }
            }
        }
        return true;
    }


    public List<String> constructResult(char[][] board){
        List<String> list = new ArrayList<String>();
        for(int i=0;i<board.length;i++){
            String text = String.valueOf(board[i]);
            list.add(text);
        }
        return list;
    }




}