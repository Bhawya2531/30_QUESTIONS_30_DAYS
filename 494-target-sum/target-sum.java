class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalsum=0;
        for(int num:nums) totalsum+=num;
        if((totalsum+target)%2!=0||Math.abs(target)>totalsum)
        return 0;
        int sum=(totalsum+target)/2;
        int n=nums.length;
        int[][]dp=new int[n+1][sum+1];
        dp[0][0]=1;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=sum;j++){
                dp[i][j]=dp[i-1][j];
                if(nums[i-1]<=j) {
                    dp[i][j]+=dp[i-1][j-nums[i-1]];
                }
            }
        }
        return dp[n][sum];
    }
}
