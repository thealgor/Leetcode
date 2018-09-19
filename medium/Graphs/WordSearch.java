package medium.Graphs;

class WordSearch {
    Set<String> visited;
    int m, n;
    char[][] board;
    boolean resultFound = false;
    public boolean exist(char[][] board, String word) {

        this.board = board;

        m = board.length;
        n = board[0].length;


        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                visited = new HashSet<String>();
                String str = new String(Character.toString(board[i][j]));
                // System.out.println(str);
                if(str.equals(word))
                    return true;
                dfs(word, str,i,j,0);
                visited.remove(i+","+j);
            }
        }


        return resultFound;
    }



    public void dfs( String word, String str, int u, int v, int index){
        int[] dx = {1,-1,0,0};
        int[] dy = {0,0,1,-1};
        visited.add(u+","+v);

        if(resultFound)
            return;

        if(index<word.length() && board[u][v]!=word.charAt(index))
            return;


        for(int i=0;i<dx.length;i++){
            int x = dx[i]+u;
            int y = dy[i]+v;

            //System.out.println(x+","+y);


            if(visited.contains(x+","+y))
                continue;

            if(x<0|| y<0 || x>m-1||y>n-1)
                continue;

            String result = str + Character.toString(board[x][y]);
            //System.out.println(result);

            if(result.equals(word)||result.indexOf(word)!=-1){
                resultFound=true;
                return;
            }

            dfs(word, result, x, y,index+1);
            visited.remove(x+","+y);
        }

    }
}
