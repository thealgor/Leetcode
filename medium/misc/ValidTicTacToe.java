package medium.misc;

class ValidTicTacToe {
    public boolean validTicTacToe(String[] board) {

        boolean xWin = false;
        boolean yWin = false;
        int[] rows = new int[3];
        int[] cols = new int[3];
        int diag=0, antidiag=0;
        int turns=0;

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(board[i].charAt(j)=='X'){
                    turns++;
                    rows[i]++;
                    cols[j]++;
                    if(i==j){
                        diag++;
                    }
                    if(i+j==2)
                        antidiag++;
                }
                else if(board[i].charAt(j)=='O'){
                    turns--;
                    rows[i]--;
                    cols[j]--;
                    if(i==j){
                        diag--;
                    }
                    if(i+j==2)
                        antidiag--;
                }

            }
        }


        if(rows[0]==3||rows[1]==3||rows[2]==3||cols[0]==3|| cols[1]==3|| cols[2]==3||diag==3||antidiag==3)
            xWin=true;

        if(rows[0]==-3||rows[1]==-3||rows[2]==-3||cols[0]==-3||cols[1]==-3||cols[2]==-3||diag==-3||antidiag==-3)
            yWin=true;

        System.out.println("rows: "+ Arrays.toString(rows) +"cols: "+ Arrays.toString(cols) +"diag: "+ diag +"antidiag: "+antidiag + "xWin: "+xWin+"yWin: "+yWin+"turns: "+turns);

        if(xWin&&turns==0||yWin&&turns==1)
            return false;

        return ((!xWin||!yWin)&&(turns==0||turns==1));




    }





}