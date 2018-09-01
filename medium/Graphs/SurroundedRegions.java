//5:18pm

class SorroundedRegions {
    char[][] b;
    boolean edgeExists;
    int m, n;
    boolean[][] visited;
    public void solve(char[][] board) {
        b=board;

        if(board.length==0||board[0].length==0)
            return;

        m=board.length;
        n=board[0].length;

        visited = new boolean[board.length][board[0].length];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){


                //  System.out.println(board[i][j]);
                if(board[i][j]=='O'&&!visited[i][j]){
                    edgeExists = false;
                    //System.out.println("hello");
                    board[i][j]='I';
                    if((i==0||i==m-1||j==0||j==n-1)){
                        edgeExists=true;
                    }
                    dfs(i,j);
                    if(!edgeExists){
                        for(int k=0;k<m;k++){
                            for(int l=0;l<n;l++){
                                if(board[k][l]=='I')
                                    board[k][l]='X';
                            }
                        }
                    }
                    else{

                        for(int k=0;k<m;k++){
                            for(int l=0;l<n;l++){
                                if(board[k][l]=='I')
                                    board[k][l]='O';
                            }
                        }
                    }

                    //System.out.println(board[i][j]);
                }
            }
        }

    }



    public void dfs(int u, int v){
        int[] dx ={1,-1,0,0};
        int[] dy ={0,0,1,-1};
        //System.out.println("hello");

        for(int i=0;i<dx.length;i++){
            int x = u+dx[i];
            int y = v+dy[i];

            if(x<0||x>=m||y<0||y>=n||visited[x][y])
                continue;

            if(b[x][y]=='X')
                continue;


            if((x==0||x==m-1||y==0||y==n-1)&&b[x][y]=='O'){
                edgeExists=true;
            }

            //System.out.println("hello");
            visited[x][y]=true;
            b[x][y]='I';
            dfs(x,y);

        }

    }



//5:18pm -- 6:15 almost one hour and crappy solution.

    class BetterSolution{
        char[][] b;
        //boolean edgeExists;
        int m, n;
        public void solve(char[][] board) {
            b=board;

            if(board.length==0||board[0].length==0)
                return;

            m=board.length;
            n=board[0].length;


            for(int i=0;i<m;i++){
                if(board[i][0]=='O'){
                    dfs(i,0);
                }

                if(board[i][n-1]=='O'){
                    dfs(i,n-1);
                }
            }

            for(int j=0;j<n;j++){
                if(board[0][j]=='O'){
                    dfs(0,j);
                }

                if(board[m-1][j]=='O'){
                    dfs(m-1,j);
                }

            }


            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(board[i][j]=='*')
                        board[i][j]='O';
                    else if(board[i][j]=='O')
                        board[i][j]='X';
                }
            }

        }



        public void dfs(int u, int v){
            int[] dx ={1,-1,0,0};
            int[] dy ={0,0,1,-1};
            b[u][v]='*';

            for(int i=0;i<dx.length;i++){
                int x = u+dx[i];
                int y = v+dy[i];

                if(x<0||x>m-1||y<0||y>n-1)
                    continue;


                if(b[x][y]!='O')
                    continue;

                //b[x][y]='*';
                dfs(x,y);
            }

        }

    }


