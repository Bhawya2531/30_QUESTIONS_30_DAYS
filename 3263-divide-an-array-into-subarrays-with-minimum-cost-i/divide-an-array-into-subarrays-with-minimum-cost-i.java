class Solution {
    public int minimumCost(int[] nums) {
        int n=nums.length;
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<n;i++){
            for(int j=i+1;j<n;j++){
                int cost=nums[0]+nums[i]+nums[j];
                ans=Math.min(ans,cost);

            }
        }
        return ans;
    }
}