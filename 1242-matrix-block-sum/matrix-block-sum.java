class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int n=mat.length;
        int m=mat[0].length;
        int [][]pref=new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                pref[i][j]=mat[i][j];

                if(i>0) pref[i][j]+=pref[i-1][j];
                if(j>0) pref[i][j]+=pref[i][j-1];
                if(i>0 && j>0) pref[i][j]-=pref[i-1][j-1];
            }
        }
        int[][]ans= new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int top=Math.max(0,i-k);
                int bottom=Math.min(n-1,i+k);
                int left=Math.max(0,j-k);
                int right=Math.min(m-1,j+k);

                int sum=pref[bottom][right];
                if(top>0) sum-=pref[top-1][right];
                if(left>0) sum-=pref[bottom][left-1];
                if(top>0 && left>0) sum+=pref[top-1][left-1];

                ans[i][j]=sum;
            }
        }
        return ans;
    }
}
