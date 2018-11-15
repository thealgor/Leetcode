import java.util.HashSet;

public class SudokuVerifier {
    public static void main(String[] args){
        SudokuVerifier sv = new SudokuVerifier();
        String input = "963174258178325649254689731821437596496852317735961824589713462317246985642598173";
        if (sv.verify(input)) {
            System.out.println("1");
        }else {
            System.out.println("0");
        }
    }
    public boolean verify(String input){
        int[][] board = new int[9][9];
        char[] c = input.toCharArray();
        for (int i = 0; i < 9 ;i++) {
            for (int j = 0; j < 9 ; j++) {
                board[i][j] = c[i * 9 + j];
            }
        }
        for (int i = 0; i < 9; i++) {
            HashSet<Integer> rows = new HashSet<>();
            HashSet<Integer> cols = new HashSet<>();
            HashSet<Integer> cube = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                int rowIndex = 3 * (i / 3);
                int colIndex = 3 * (i % 3);
                if (!rows.add(board[i][j])) {
                    return false;
                }
                if (!cols.add(board[j][i])) {
                    return false;
                }
                if (!cube.add(board[rowIndex + j / 3][colIndex + j % 3])){
                    return false;
                }                       
            }
        }
        return true;
    }
}
