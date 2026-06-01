class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[]dp=new int[n+1];
        dp[n]=0;

        for(int i=n-1;i>=0;i--){
            int curr_max=0; // not outside cuzfor every new i we need fresh curr_max and result 
            int result=0;
            for(int j=i;j<n&&j-i+1<=k;j++){
                curr_max=Math.max(curr_max,arr[j]);
                int len=j-i+1;
                int sum=(len*curr_max)+dp[j+1];
                result=Math.max(result,sum);
            }
            dp[i]=result;
        }
        return dp[0];
    }
}