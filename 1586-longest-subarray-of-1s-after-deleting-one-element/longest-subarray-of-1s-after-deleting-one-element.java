class Solution {
    public int longestSubarray(int[] nums) {
     int left=0;
     int length=0;
     int count=0;
     for(int right=0;right<nums.length;right++){
        if(nums[right]==0) count++;
        while(count>1){
            if(nums[left]==0)
            count--;
            left++;
        }
        length=Math.max(length,right-left);
     }
     return length;
    }
}

       