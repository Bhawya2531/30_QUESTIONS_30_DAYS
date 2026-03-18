class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] ans = new int[n];
        int idx = 0;

        // < pivot
        for (int num : nums) {
            if (num < pivot) {
                ans[idx++] = num;
            }
        }

        // == pivot
        for (int num : nums) {
            if (num == pivot) {
                ans[idx++] = num;
            }
        }

        // > pivot
        for (int num : nums) {
            if (num > pivot) {
                ans[idx++] = num;
            }
        }

        return ans;
    }
}