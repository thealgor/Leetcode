
//got it wrong first time. Idea is to first compute the mines across the neighbors before adding to the queue. and the go over and add only if no mines are present. Because it is possible that my neihbors can contain both Es and Ms at the same time - Adding E to the queue is going to result in bad solution.

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {

        if(board[click[0]][click[1]]=='M'){
            board[click[0]][click[1]]='X';
            return board;
        }
        Set<String> visited = new HashSet();
        dfs(board,click[0],click[1],visited);
        return board;
    }

    public void dfs(char[][] board, int u, int v, Set<String> visited){

        Queue<String> q = new LinkedList();

        q.add(u+","+v);
        visited.add(u+","+v);

        while(!q.isEmpty()){
            String str = q.poll();
            u = Integer.parseInt(str.split(",")[0]);
            v = Integer.parseInt(str.split(",")[1]);

            if(board[u][v]!='E' && board[u][v]!='M')  continue;


            int[] dx = {1,-1,0,0,1,-1,1,-1};
            int[] dy = {0,0,1,-1,1,-1,-1,1};

            int m=0, e=0, n=0;
            for(int i=0;i<dx.length;i++){
                int x = u+dx[i];
                int y = v+dy[i];

                if(x<0 || y<0 || x>board.length-1 || y>board[0].length-1 ) continue;

                if(board[x][y]=='M')
                    m++;

            }

            if(m!=0){
                board[u][v]=(char) (m+'0');
                m=0;
            }
            else{
                board[u][v]='B'; //missed this part
                for(int i=0;i<dx.length;i++){
                    int x = u+dx[i];
                    int y = v+dy[i];

                    if(x<0 || y<0 || x>board.length-1 || y>board[0].length-1) continue;

                    if(board[x][y]=='E'){
                        q.add(x+","+y);
                    }

                }
            }

        }

    }
}


//DFS solution
public class SolutionDFS {
    public char[][] updateBoard(char[][] board, int[] click) {
        int m = board.length, n = board[0].length;
        int row = click[0], col = click[1];

        if (board[row][col] == 'M') { // Mine
            board[row][col] = 'X';
        }
        else { // Empty
            // Get number of mines first.
            int count = 0;
            for (int i = -1; i < 2; i++) {
                for (int j = -1; j < 2; j++) {
                    if (i == 0 && j == 0) continue;
                    int r = row + i, c = col + j;
                    if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                    if (board[r][c] == 'M' || board[r][c] == 'X') count++;
                }
            }

            if (count > 0) { // If it is not a 'B', stop further DFS.
                board[row][col] = (char)(count + '0');
            }
            else { // Continue DFS to adjacent cells.
                board[row][col] = 'B';
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2; j++) {
                        if (i == 0 && j == 0) continue;
                        int r = row + i, c = col + j;
                        if (r < 0 || r >= m || c < 0 || c < 0 || c >= n) continue;
                        if (board[r][c] == 'E') updateBoard(board, new int[] {r, c});
                    }
                }
            }
        }

        return board;
    }
}

