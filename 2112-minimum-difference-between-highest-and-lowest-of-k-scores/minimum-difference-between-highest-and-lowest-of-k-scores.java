class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        Arrays.sort(nums);    
        int mindiff=Integer.MAX_VALUE;
        int left=0;  
for (int right = 0; right < nums.length; right++) {
    if(right-left+1==k){
        mindiff=Math.min(mindiff,nums[right]-nums[left]);
        left++;
    }
}
return mindiff;
    }
}