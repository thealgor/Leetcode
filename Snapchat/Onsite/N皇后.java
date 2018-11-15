难点在于follow up，就是旋转棋盘都被计算成同一个结果，所以得到结果之后就要转一转。
感觉是rotate Array，先上下翻转，然后对角线翻转就行了。
上下翻转可以用Collection.reverse(),解决，但是对角线这个还是先toCharArray()然后再翻转吧。

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        if(n == 0) return result;
        search(n, new ArrayList<Integer>(), result);
        return result;
    }
    public void search(int n, List<Integer> cols, List<List<String>> result){
        if(cols.size() == n){
            result.add(drawBoard(cols));
            return;
        }
        for(int col = 0; col < n; col++){
            if(isValid(col, cols)){
                cols.add(col);
                search(n, cols, result);
                cols.remove(cols.size()-1);
            }
        }
    }
    public boolean isValid(int col, List<Integer> cols){
        for(int i = 0; i < cols.size(); i++){
            if(cols.get(i) == col){
                return false;
            }
            if(cols.get(i) - i == col - cols.size()){
                return false;
            }
            if(cols.get(i) + i == col + cols.size()){
                return false;
            }
        }
        return true;
        
    }
    public List<String> drawBoard(List<Integer> cols){
        List<String> board = new ArrayList<>();
        for(int i = 0; i < cols.size(); i++){
            StringBuilder curSB = new StringBuilder();
            for(int j = 0; j < cols.size(); j++){
                if(j == cols.get(i)){
                    curSB.append('Q');
                }
                else{
                    curSB.append('.');
                }
            }
            board.add(curSB.toString());
        }
        return board;
    }
}