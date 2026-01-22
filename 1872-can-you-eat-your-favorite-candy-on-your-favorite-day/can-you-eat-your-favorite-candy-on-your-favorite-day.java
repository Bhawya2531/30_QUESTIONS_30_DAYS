class Solution {
    public boolean[] canEat(int[] candiesCount, int[][] queries) {
        int n=candiesCount.length;
        long[]prefix=new long[n];
        prefix[0]=candiesCount[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+candiesCount[i];
        }
        boolean[]ans=new boolean[queries.length];
        for(int i=0;i<queries.length;i++){
        int type=queries[i][0];
        int favday=queries[i][1];
        int dailycap=queries[i][2];
        long mineat=favday+1L;
        long maxeat=(long)(favday+1)*dailycap;
        long start=(type==0)?1:prefix[type-1]+1;
        long end=prefix[type];
        ans[i]=(maxeat>=start&&mineat<=end);
        }
        return ans;
    }
}





    