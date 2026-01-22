import java.util.Arrays;

class Solution {
    public int[] numberGame(int[] nums) {
        // Sort the array first
        Arrays.sort(nums);

        // Swap every adjacent pair
        for (int i = 1; i < nums.length; i += 2) {
            int temp = nums[i];
            nums[i] = nums[i - 1];
            nums[i - 1] = temp;
        }

        return nums;
    }
}
