class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
       boolean[][]dp=new boolean[n][n];
       int count=0;
       for(int L=1;L<=n;L++){
        for(int i=0;i<=n-L;i++){
            int j=i+L-1;
            if(s.charAt(i)==s.charAt(j)){
                if(L<=2){
                    dp[i][j]=true;
                }else{
                    dp[i][j]=dp[i+1][j-1];
                }
                if(dp[i][j]) count++;
            }
        }
       }
       return count;
    }
}

               