class Solution {
    public long getDescentPeriods(int[] prices) {
        long curr=1;
        long count=1;
        int n=prices.length;
        for(int i=1;i<n;i++){
            if(prices[i-1]-prices[i]==1){
            curr++;
        }else{
            curr=1;
        }
    count+=curr;
        }  
    return count;
    }
}
