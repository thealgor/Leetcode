class Solution {
    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 )
            return 0;
        int m = matrix.length, n=matrix[0].length,max=0;
        int[] h = new int[n+1];
        h[n]=0;

        for(int i=0;i<m;i++){
            Stack<Integer> s = new Stack();
            for(int j=0;j<n+1;j++){
                if(j<n)
                    if(matrix[i][j]=='1')
                        h[j]+=1;
                    else
                        h[j]=0;

                if(s.isEmpty() || h[s.peek()]<=h[j]){
                    s.push(j);
                }
                else{
                    while(!s.isEmpty() && h[s.peek()]>h[j]){
                        int top = s.pop();
                        int area = h[top]*(s.isEmpty()?j:(j-s.peek()-1));
                        max = Math.max(area,max);
                    }
                    s.push(j);
                }


            }
        }

        return max;

    }
}