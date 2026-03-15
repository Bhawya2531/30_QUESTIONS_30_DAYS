class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n=cardPoints.length;
        int sum=0;
        int l;
        int r;
        for(l=0;l<k;l++){
            sum+=cardPoints[l];
        }
        int maxsum=sum;
        l=k-1;
        for( r=n-1;r>=n-k;r--){
            sum+=cardPoints[r];
            sum-=cardPoints[l];
            l--;
        maxsum=Math.max(sum,maxsum);
        }
        return maxsum;
    }
}
       