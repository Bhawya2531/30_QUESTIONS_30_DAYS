class Solution {
    public int lengthOfLIS(int[] nums) {
       int n=nums.length;
       int[][]dp=new int[n+1][n+1];
       for(int i=n-1;i>=0;i--){
        for(int prev=i-1;prev>=-1;prev--){ //since prev is the last element it must be less than i 
            int skip= dp[i+1][prev+1]; //since prev starts from -1 nd array cant store negative soshiftcol
            int take=0;
            if(prev==-1||nums[prev]<nums[i]){
                take=1+dp[i+1][i+1];//prev value is i here and since we shifted col for prev i->i+1
            }
       
        dp[i][prev+1]=Math.max(take,skip); //  take skip correspond to this cell in recursion 
    }
}
return dp[0][0];    //cz recursion started with 0,-1 
}
}

