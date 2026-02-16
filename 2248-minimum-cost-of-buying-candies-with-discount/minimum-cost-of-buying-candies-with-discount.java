class Solution {
    public int minimumCost(int[] cost) {
        int n=cost.length;
        int sum=0;
        int sum2=0;
        Arrays.sort(cost);
        for(int i=0;i<cost.length;i++){
            sum+=cost[i];
        }
        for(int j=n-3;j>=0;j-=3){
            sum2+=cost[j];
        }
        int ans=sum-sum2;
        return ans;
    }
}