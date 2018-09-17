class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        List<Integer> result = new ArrayList<Integer>();
        
        //System.out.println(matrix+","+matrix[0]+","+matrix.length+","+matrix[0].length);
        
         if (matrix.length == 0) {
            return result;
        }
        
        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length-1;
        
       
        
        while(rowBegin<=rowEnd && colBegin<=colEnd){
            //Go right
            System.out.println(colBegin+ ","+colEnd);
            for(int i=colBegin;i<=colEnd;i++){
                result.add(matrix[rowBegin][i]);               
            }
 
            rowBegin++;
            //go down
            for(int i=rowBegin;i<=rowEnd;i++){
                result.add(matrix[i][colEnd]);
                System.out.println(result);
            }
            colEnd--;
            //goLeft
            
            if(rowBegin<=rowEnd){
                 for(int i=colEnd;i>=colBegin;i--){
                    result.add(matrix[rowEnd][i]);
                }
                rowEnd--;
            }
           
            if(colBegin<=colEnd){
                for(int i=rowEnd;i>=rowBegin;i--){
                    result.add(matrix[i][colBegin]);
                }
                colBegin++;
            }
 
        }
        
        return result;
    }
}


class Solution {
public:
    vector<int> spiralOrder(vector<vector<int>> &matrix) {
        vector<int> result;
        if (matrix.empty()) return result;
        result = matrix[0];  // no need to check the first row
        int dirs[4][2] = {{1, 0}, {0, -1}, {-1, 0}, {0, 1}};  // direction offsets
        int d = 0;  // direction index
        int m = matrix.size();
        int n = matrix[0].size();
        int pos[2] = {0, n - 1};  // start from the top right corner
        int i = (m - 1) * n;  // number of the rest numbers
        while (i > 0) {
            for (int j = 1; j < m; j++) {
                i--;
                pos[0] += dirs[d][0]; pos[1] += dirs[d][1];
                result.push_back(matrix[pos[0]][pos[1]]);
            }
            m--;  // decrease the size of row or column
            swap(m, n);  // switch between horizontal and vertical mode
            d = (d + 1) % 4;  // loop between direction offsets
        }
        return result;
    }
};
