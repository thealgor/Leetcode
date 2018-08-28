package DP;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] minCoins = new int[amount+1];
        minCoins[0]=0;
        for(int i=1;i<=amount;i++)
            minCoins[i]=Integer.MAX_VALUE;

        for(int i=1;i<=amount;i++){
            for(int j=0;j<coins.length;j++){
                if(i>=coins[j]&&minCoins[i-coins[j]]<minCoins[i]){
                    minCoins[i]=minCoins[i-coins[j]]+1;
                    // System.out.println("i: "+ i+ "coins: "+ coins[j] + " minCoins: "+minCoins[i]);
                }
            }
        }

        if(minCoins[amount]==Integer.MAX_VALUE)
            return -1;

        return minCoins[amount];

    }
}