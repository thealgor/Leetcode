题目是给一个整数数组，其中所有数字都大于等于1。这些数字可以用加号，乘号和括号连接成一个表达式，求表达式的最大值。
二维DP搞定。给个一个数组[1,1,2,1]，然后用+ * （）三操作求出这个数组的最大值，这个题返回6。
Follow up是考虑0和负数。这时需要维护两个DP表，同时跟踪表达式的最大值和最小值。

public class Maximum_Expression_Value {
    public int getMax(int[] numbers){
        if (numbers == null || numbers.length == 0){
            return 0;
        }
        int len = numbers.length;
        int[][] dp = new int[len][len];
        for (int i = len-1; i >= 0; i--){
            for (int j = i; j < len; j++){
                if (i == j){
                    dp[i][j] = numbers[i];
                }
                else if(i + 1 == j){
                    dp[i][j] = Math.max(numbers[i] + numbers[j], numbers[i] * numbers[j]);
                }
                else {
                    //这里一个循环治好了所有毛病，从中间切，左边和右边各代表一个数字。
                    for (int k = i; k < j; k++){
                        dp[i][j] = Math.max(dp[i][j], Math.max(dp[i][k]+dp[k+1][j], dp[i][k]*dp[k+1][j]));
                    }
                }
            }
        }
        return dp[0][len-1];
    }
}