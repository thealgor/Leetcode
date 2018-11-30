class Solution {
    //infinite grid solution
    //Not really keen on doing it in Java. What I do is I have the coordinates of all living cells in a set. 
    //Then I count the living neighbors of all cells by going through the living cells and increasing the counter of their neighbors (thus cells without living neighbor will not be in the counter). 
    //Afterwards I just collect the new set of living cells by picking those with the right amount of neighbors. Does that help?
    
    
    def gameOfLifeInfinite(self, live):
    neighbors = collections.Counter()
    for i, j in live:
        for I in (i-1, i, i+1):
            for J in (j-1, j, j+1):
                if I != i or J != j:
                    neighbors[I, J] += 1
    new_live = set()
    for ij in neighbors.keys():
        if neighbors[ij] == 3 or neighbors[ij] == 2 and ij in live:
            new_live.add(ij)
    return new_live
    
    
    
    private Set<Coord> gameOfLife(Set<Coord> live) {
        Map<Coord,Integer> neighbours = new HashMap<>();
        for (Coord cell : live) {
            for (int i = cell.i-1; i<cell.i+2; i++) {
                for (int j = cell.j-1; j<cell.j+2; j++) {
                    if (i==cell.i && j==cell.j) continue;
                    Coord c = new Coord(i,j);
                    if (neighbours.containsKey(c)) {
                        neighbours.put(c, neighbours.get(c) + 1);
                    } else {
                        neighbours.put(c, 1);
                    }
                }
            }
        }
        Set<Coord> newLive = new HashSet<>();
        for (Map.Entry<Coord,Integer> cell : neighbours.entrySet())  {
            if (cell.getValue() == 3 || cell.getValue() == 2 && live.contains(cell.getKey())) {
                newLive.add(cell.getKey());
            }
        }
        return newLive;
    }

        private static class Coord {
        int i;
        int j;
        private Coord(int i, int j) {
            this.i = i;
            this.j = j;
        }
        public boolean equals(Object o) {
            return o instanceof Coord && ((Coord)o).i == i && ((Coord)o).j == j;
        }
        public int hashCode() {
            int hashCode = 1;
            hashCode = 31 * hashCode + i;
            hashCode = 31 * hashCode + j;
            return hashCode;
        }
    }

       public void gameOfLife(int[][] board) {
        Set<Coord> live = new HashSet<>();
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                if (board[i][j] == 1) {
                    live.add(new Coord(i,j));
                }
            }
        };
        live = gameOfLife(live);
        for (int i = 0; i<m; i++) {
            for (int j = 0; j<n; j++) {
                board[i][j] = live.contains(new Coord(i,j))?1:0;
            }
        };
        
    }
    
    /**
    *  To solve it in place, we use 2 bits to store 2 states:

[2nd bit, 1st bit] = [next state, current state]

- 00  dead (next) <- dead (current)
- 01  dead (next) <- live (current)  
- 10  live (next) <- dead (current)  
- 11  live (next) <- live (current) 
In the beginning, every cell is either 00 or 01.
Notice that 1st state is independent of 2nd state.
Imagine all cells are instantly changing from the 1st to the 2nd state, at the same time.
Let's count # of neighbors from 1st state and set 2nd state bit.
Since every 2nd state is by default dead, no need to consider transition 01 -> 00.
In the end, delete every cell's 1st state by doing >> 1.
For each cell's 1st bit, check the 8 pixels around itself, and set the cell's 2nd bit.

Transition 01 -> 11: when board == 1 and lives >= 2 && lives <= 3.
Transition 00 -> 10: when board == 0 and lives == 3.
To get the current state, simply do

board[i][j] & 1
To get the next state, simply do

board[i][j] >> 1

    */
    
    //no extra space
    
    public void gameOfLife(int[][] board) {
    if (board == null || board.length == 0) return;
    int m = board.length, n = board[0].length;

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int lives = liveNeighbors(board, m, n, i, j);

            // In the beginning, every 2nd bit is 0;
            // So we only need to care about when will the 2nd bit become 1.
            if (board[i][j] == 1 && lives >= 2 && lives <= 3) {  
                board[i][j] = 3; // Make the 2nd bit 1: 01 ---> 11
            }
            if (board[i][j] == 0 && lives == 3) {
                board[i][j] = 2; // Make the 2nd bit 1: 00 ---> 10
            }
        }
    }

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            board[i][j] >>= 1;  // Get the 2nd state.
        }
    }
}

public int liveNeighbors(int[][] board, int m, int n, int i, int j) {
    int lives = 0;
    for (int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m - 1); x++) {
        for (int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n - 1); y++) {
            lives += board[x][y] & 1;
        }
    }
    lives -= board[i][j] & 1;
    return lives;
}
    
    
    
    
    
    
   //my solution 
    
    
    
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
