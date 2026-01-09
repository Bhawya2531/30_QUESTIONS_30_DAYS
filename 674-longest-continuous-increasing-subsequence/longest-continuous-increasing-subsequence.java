class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length==0) return 0;
        int left=0;
        int maxLen=1;
        for(int right=1;right<nums.length;right++){
            if(nums[right]<=nums[right-1]){
                left=right;
            }
           maxLen=Math.max(maxLen,right-left+1);
        }
        return maxLen;
    }
}