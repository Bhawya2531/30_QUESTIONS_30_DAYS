class Solution {
    public int countHillValley(int[] nums) {
        int count = 0;
        int prevDistinctIndex = 0;

        for (int i = 1; i < nums.length - 1; i++) {
            // Skip equal adjacent elements
            if (nums[i] == nums[i + 1]) continue;

            // Check hill
            if (nums[i] > nums[prevDistinctIndex] && nums[i] > nums[i + 1]) {
                count++;
            }
            // Check valley
            if (nums[i] < nums[prevDistinctIndex] && nums[i] < nums[i + 1]) {
                count++;
            }

            prevDistinctIndex = i;
        }
        return count;
    }
}
