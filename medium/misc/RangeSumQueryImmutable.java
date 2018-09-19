package medium.misc;

import com.sun.tools.javac.util.Pair;

import java.util.HashMap;
import java.util.Map;

class RangeSumQueryImmutable {

    private int[] sum;

    public NumArray(int[] nums) {
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sum[i + 1] = sum[i] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }

    private Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

    public void  NumArrayTLE(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                map.put(new Pair(i, j), sum);
            }
        }
    }

    public int sumRangeTLE(int i, int j) {
        return map.get(new Pair(i, j));
    }

    public class Pair1{
        int i;
        int j;
        public Pair1(int i, int j){
            this.i=i;
            this.j=j;
        }

        @Override
        public boolean equals(Object o){
            Pair1 p1 = (Pair1)o;
            return (i==p1.i && j==p1.j);
        }

        @Override
        public int hashCode() {
            int tmp = ( j +  ((i+1)/2));
            return i +  ( tmp * tmp);
        }


    }

    int[] nums;
    Map<Pair1,Integer> map1 = new HashMap<Pair1,Integer>();
    public void NumArrayOther(int[] nums) {
        this.nums = nums;

        //method 2;

        for(int i=0;i<nums.length;i++){
            int sum=0;
            for(int j=i;j<nums.length;j++){
                sum+=nums[j];
                map1.put(new Pair1(i,j),sum);
            }
        }

        //System.out.println(map);
    }

    public int sumRangeOther(int i, int j) {
        return map1.get(new Pair1(i,j));
    }


    public int sumRangeBruteForce(int i, int j){
        if(!(i<=j&& i>=0 && i<nums.length&&j<nums.length))
            return -1;

        int sum = 0;
        for(int k=i;k<=j;k++){
            //System.out.println(nums[k]);
            sum+=nums[k];
        }
        return sum;
    }
}


class RangeSumQueryBetterSolution {

    int[][] m;

    public NumMatrix(int[][] matrix) {
        if(matrix.length==0 || matrix[0].length==0)
            return;

        int rows = matrix.length;
        int cols = matrix[0].length;



        this.m= new int[rows][cols];


        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(j==0){
                    m[i][0]=matrix[i][0];
                    continue;
                }

                m[i][j]=m[i][j-1]+matrix[i][j];
            }
        }




    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for(int i=row1;i<=row2;i++){
            if(col1==0){
                sum+=m[i][col2];
                continue;
            }

            sum+=m[i][col2]-m[i][col1-1];
        }
        return sum;
    }
}
