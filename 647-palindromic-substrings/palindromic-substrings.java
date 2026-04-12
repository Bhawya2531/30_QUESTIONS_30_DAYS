class Solution {
    public int countSubstrings(String s) {
        int n=s.length();
        int[][]t=new int[n][n];
        //initialize dp array with -1
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                t[i][j]=-1;
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(check(s,i,j,t)){
                    count++;
                }
            }
        }
    return count;
    }
    boolean check(String s, int i, int j, int[][]t){
        if(i>=j) return true;
        if(t[i][j]!=-1){
            return t[i][j]==1;
        }
        if(s.charAt(i)!=s.charAt(j)){
            t[i][j]=0;
            return false;
        }
        boolean res=check(s,i+1,j-1,t);
        t[i][j]=res? 1:0;
        return res;
    }
}
       