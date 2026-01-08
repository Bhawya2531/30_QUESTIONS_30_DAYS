class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        Arrays.sort(nums);
        int sum=0;
        int left=0;
        int minsum=Integer.MAX_VALUE;       
        for(int right=0;right<nums.length;right++){
            if(right-left+1==k){
                 minsum=Math.min(minsum,nums[right]-nums[left]);
            left++;
        }
        }
        
        return minsum;
    }
}

            