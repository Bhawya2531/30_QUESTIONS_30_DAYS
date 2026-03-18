class Solution {
    public int longestOnes(int[] nums, int k) {
       int left=0;
       int zerocount=0;
       int max_ones=0;
       for(int right=0;right<nums.length;right++){
        if(nums[right]==0) zerocount++;
        while(zerocount>k){
            if(nums[left]==0)
            zerocount--;
            left++;
        }
        max_ones=Math.max(max_ones,right-left+1);
       }
       return max_ones;
    }
}