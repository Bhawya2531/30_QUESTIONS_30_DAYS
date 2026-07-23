class Solution {
    public int maxProfit(int[] prices) {
          int n=prices.length;
        int[][][]dp=new int[n+1][2][3];
        for(int i=n-1;i>=0;i--){
            for(int trans=1;trans<=2;trans++){
                dp[i][1][trans]=Math.max(-prices[i]+dp[i+1][0][trans],dp[i+1][1][trans]);
                dp[i][0][trans]=Math.max(prices[i]+dp[i+1][1][trans-1],dp[i+1][0][trans]);
            }
        }
        return dp[0][1][2];
    }
}

                                        

            