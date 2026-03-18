class Solution {
    public int maxProfit(int[] prices) {
        int minprice=prices[0];
        int maxprofit=0;
        int n=prices.length;
        for(int i=0;i<n;i++){
            minprice=Math.min(minprice,prices[i]);
            int profit=prices[i]-minprice;
            maxprofit=Math.max(maxprofit,profit);
        }
        return maxprofit;
    }
}


       