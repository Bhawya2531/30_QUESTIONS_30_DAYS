class Solution {
    public int uniquePaths(int m, int n) {
        int[][]dp=new int[m][n];
        //initialize with -1
        for(int i=0;i<m;i++){
                Arrays.fill(dp[i],-1);
            }
        return solve(0,0,m,n,dp);
    }

        private int solve(int i, int j, int m, int n,int[][]dp){
            //base case
            if(i==m-1&&j==n-1){
                return 1;
            }
            //out of bounds
            if(i<0||i>=m||j<0||j>=n){
                return 0;
            }
            //memoization check
            if(dp[i][j]!=-1) return dp[i][j];
            int right=solve(i,j+1,m,n,dp);
            int down=solve(i+1,j,m,n,dp);
            //store result
            dp[i][j]= right+down;
            return dp[i][j];
        }

        }
