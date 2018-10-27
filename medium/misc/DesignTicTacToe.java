class TicTacToe {

    int[] rows, cols;
    int diag, antidiag, n,v;
    /** Initialize your data structure here. */
    public TicTacToe(int n) {
        rows = new int[n];
        cols = new int[n];
        this.n = n;
    }

    /** Player {player} makes a move at ({row}, {col}).
     @param row The row of the board.
     @param col The column of the board.
     @param player The player, can be either 1 or 2.
     @return The current winning condition, can be either:
     0: No one wins.
     1: Player 1 wins.
     2: Player 2 wins. */
    public int move(int row, int col, int player) {
        if(player==1){
            rows[row]++;
            cols[col]++;

            if(row==col)
                diag++;

            if(row+col==n-1)
                antidiag++;
        }
        else{
            rows[row]--;
            cols[col]--;
            if(row==col)
                diag--;

            if(row+col==n-1)
                antidiag--;
        }

        return returnIfPlayerWon();

    }

    public int returnIfPlayerWon(){

        if(diag==n || antidiag==n)
            return 1;
        else if(diag==-n || antidiag==-n)
            return 2;

        for(int i=0;i<n;i++){
            if(rows[i]==n || cols[i]==n)
                return 1;
            else if(rows[i]==-n || cols[i]==-n)
                return 2;
        }

        return 0;
    }


}

//more cleaner solution
class Solution1{
    int[] rows, cols;
    int diagonal, anti_diagonal, target;

    public Solution1(int n) {
        rows = new int[n];
        cols = new int[n];
        diagonal = 0;
        anti_diagonal = 0;
        target = n;
    }

    public int move(int row, int col, int player) {
        int sign = player == 1 ? 1 : -1, res = sign * target;
        rows[row] += sign;
        cols[col] += sign;
        if(row == col) diagonal += sign;
        if(row == target-1-col) anti_diagonal += sign;
        if(rows[row] == res || cols[col] == res || diagonal == res || anti_diagonal == res) return player;
        else return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */