class Solution {
    public int longestSubarray(int[] nums) {
       int left=0;
       int len=0;
       int zeros=0;
       for(int right=0;right<nums.length;right++){
        if(nums[right]==0) zeros++;
       
       while(zeros>1){        // zeros>1 means that more than one zero in our window        
        if(nums[left]==0)    // we can't replca that
        zeros--;
       left++;
       }
       len=Math.max(len,right-left);
    }
return len;
}
}

