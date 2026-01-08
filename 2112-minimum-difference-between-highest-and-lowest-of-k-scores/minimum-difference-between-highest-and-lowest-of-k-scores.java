class Solution {
    public int minimumDifference(int[] nums, int k) {
        if (k == 1) return 0;
        Arrays.sort(nums);      
       int minsum = nums[k - 1] - nums[0];

for (int right = k; right < nums.length; right++) {
    minsum = Math.min(minsum, nums[right] - nums[right - k + 1]);
}
return minsum;
    }
}
