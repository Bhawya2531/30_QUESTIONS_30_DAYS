class Solution {
    public int minimumDifference(int[] nums, int k) {
       Arrays.sort(nums);
       int mindif=Integer.MAX_VALUE;
       int left=0;
       for(int right=0;right<nums.length;right++){
        if(right-left+1==k){
            mindif=Math.min(mindif,nums[right]-nums[left]);
             left++;
        }
        
       } 
       return mindif;
    }
}