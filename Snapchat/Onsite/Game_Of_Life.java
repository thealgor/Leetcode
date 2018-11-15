函数接口都自己定义。follow up有board很大怎么办，会越过数组的边界，各种follow up
0 -> 1 : 3
1 -> 0 : 2

public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0 || board[0].length == 0) return;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                int nbNum = getNB(board, i, j);
                if(board[i][j] == 0){
                    if(nbNum == 3){
                        board[i][j] = 3;
                    }
                }
                else{
                    if(nbNum < 2){
                        board[i][j] = 2;
                    }
                    else if(nbNum > 3){
                        board[i][j] = 2;
                    }
                }
            }
        }
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] = board[i][j] % 2;
            }
        }
        return;
    }
    public int getNB(int[][] board, int row, int col){
        int result = 0;
        int[] dx = {-1,0,1,-1,1,-1,0,1};
        int[] dy = {-1,-1,-1,0,0,1,1,1};
        for(int k = 0; k < 8; k++){
            int rowN = row + dx[k];
            int colN = col + dy[k];
            if(rowN < 0 || rowN >= board.length || colN < 0 || colN >= board[0].length){
                continue;
            }
            if(board[rowN][colN] > 0 && board[rowN][colN] < 3){
                result += 1;
            }
        }
        return result;
    }
}

follow up: 需要定义node的坐标，一个list里面存活着的node，每次给自己所有的合法位置的neighbour发一个1，就是一个map
Map<Position, Intger> map = 位置，1的个数。
然后下次就可以遍历这个map，根据1的个数确定死活，唯有3个才能存活，然后用这个结果再去更新list。