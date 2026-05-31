class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][]dp=new int[m][n];
        if(obstacleGrid[0][0]==1){
            return 0;
        }
        dp[0][0]=1;
               for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {

                // obstacle → skip
                if(obstacleGrid[i][j] == 1) {
                    continue;
                }

                // DOWN
                if(i + 1 < m && obstacleGrid[i+1][j] == 0) {
                    dp[i+1][j] += dp[i][j];
                }

                // RIGHT
                if(j + 1 < n && obstacleGrid[i][j+1] == 0) {
                    dp[i][j+1] += dp[i][j];
                }
            }
        }

        return dp[m-1][n-1];
    }
}
        