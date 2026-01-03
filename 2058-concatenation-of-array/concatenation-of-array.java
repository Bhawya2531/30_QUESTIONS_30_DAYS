class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
       int[]ans=new int[2*n];
       fill(nums,ans,0);
       return ans;

    }
    private void fill(int[]nums, int[]ans, int i){
        if(i==nums.length) return;
        ans[i]=nums[i];
        ans[i+nums.length]=nums[i];
        fill(nums,ans,i+1);
    }
}