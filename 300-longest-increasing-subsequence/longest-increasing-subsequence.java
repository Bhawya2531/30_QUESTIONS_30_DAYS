class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        Integer[][]dp=new Integer[n+1][n+1];
        return solve(nums,0,-1,dp);
    }
        
        private int solve(int[]nums,int i, int prev,Integer[][]dp){
           
            if(i>=nums.length){ return 0;
        }
         if(dp[i][prev+1]!=null) {
                return dp[i][prev+1];
            }
        int take=0;
        if(prev==-1||nums[prev]<nums[i]){
        take=1+solve(nums,i+1,i,dp);
        }
        int skip=solve(nums,i+1,prev,dp);
        return dp[i][prev+1]=Math.max(take,skip);
    }
}