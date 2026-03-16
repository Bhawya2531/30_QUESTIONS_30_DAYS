class Solution {
    public boolean isCovered(int[][] ranges, int left, int right) {
        int[]diff=new int[52];
        for(int []r:ranges){
            diff[r[0]]+=1;
            diff[r[1]+1]-=1;
        }
        int sum=0;
        for(int i=1;i<=50;i++){
            sum+=diff[i];
            if(i>=left && i<=right && sum==0){
                return false;
            }
        }
        return true;
    }
}

           