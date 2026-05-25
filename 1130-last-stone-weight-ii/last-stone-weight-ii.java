class Solution {
    public int lastStoneWeightII(int[] stones) {
        int n=stones.length;
        int total=0;
        for(int stone:stones)
        total+=stone;
        int target=total/2;
        boolean[][]dp=new boolean[n+1][target+1];
        for(int i=0;i<=n;i++)
            dp[i][0]=true;
        for(int i=1;i<=n;i++){
            int stone=stones[i-1];
        for(int j=1;j<=target;j++){
            dp[i][j]=dp[i-1][j];
            if(j>=stone){
                dp[i][j]=dp[i][j]||dp[i-1][j-stone];
            }
        }
        }
        for(int j=target;j>=0;j--){
            if(dp[n][j]){
                return total-2*j;
            }
        }
        return 0;
        }
    }

           