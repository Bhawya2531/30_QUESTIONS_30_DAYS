class Solution {
    public int minFallingPathSum(int[][] matrix) {
       int n=matrix.length;
       int[][]dp=new int[n][n];
       for(int j=0;j<n;j++){ //start anywhere in the first row
        dp[0][j]=matrix[0][j];
       }
       for(int i=1;i<n;i++){
        for(int j=0;j<n;j++){
           if(j==0){
            dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j+1]);
           }else if(j==n-1){
            dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],dp[i-1][j-1]);
           }else{
            dp[i][j]=matrix[i][j]+Math.min(dp[i-1][j],Math.min(dp[i-1][j-1],dp[i-1][j+1]));
           }
        }
    }
        int ans = Integer.MAX_VALUE;

for(int j = 0; j < n; j++) {
    ans = Math.min(ans, dp[n-1][j]);
}

return ans;
       }
    }

      