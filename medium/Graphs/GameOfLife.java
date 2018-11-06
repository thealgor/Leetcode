class Solution {
    public void gameOfLife(int[][] board) {
        
        if(board==null || board.length==0)
            return;
        
        
        int[][] nextState = new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int[] dx = {1,-1,0,0,1,-1,1,-1};
                int[] dy = {0,0,1,-1,1,-1,-1,1};
                
                int count1 = 0, count0=0;
                for(int k=0;k<dx.length;k++){
                    int u = i+dx[k];
                    int v = j+dy[k];
                    
                    if(u<0 || v<0 || u>board.length-1 || v>board[0].length-1) continue;
                    
                    if(board[u][v]==1) count1++;
                    
                }
                
            
                //rules
                
                if(board[i][j]==1){
                    if(count1<2)
                        nextState[i][j]=0;
                    else if(count1==2 || count1==3)
                        nextState[i][j]=1;
                    else if(count1>3)
                        nextState[i][j]=0;
                    else
                        nextState[i][j]=board[i][j];
                        
                }
                else if(board[i][j]==0){
                   if(count1==3) 
                       nextState[i][j]=1;
                    else
                        nextState[i][j]=board[i][j];
                }
                
                
            }
        }
        
        for(int i=0;i<nextState.length;i++){
            for(int j=0;j<nextState[0].length;j++)
                board[i][j] = nextState[i][j];
        }
        
    }
}
