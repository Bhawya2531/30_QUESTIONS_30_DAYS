class Solution {
    public int countElements(int[] nums) {
        Arrays.sort(nums);

        int min = nums[0];
        int max = nums[nums.length - 1];
        int count = 0;

        for (int num : nums) {
            if (num > min && num < max) {
                count++;
            }
        }
        return count;
    }
}
