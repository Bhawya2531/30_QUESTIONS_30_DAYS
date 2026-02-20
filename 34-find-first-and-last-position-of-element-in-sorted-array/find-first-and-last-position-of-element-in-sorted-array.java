class Solution {

    public int[] searchRange(int[] nums, int target) {

        int n = nums.length;

        int leftMost = findLeftMost(nums, target, n);
        int rightMost = findRightMost(nums, target, n);

        return new int[]{leftMost, rightMost};
    }

    private int findLeftMost(int[] nums, int target, int n) {

        int l = 0, r = n - 1;
        int leftMost = -1;

        while(l <= r) {

            int mid = l + (r - l) / 2;

            if(nums[mid] == target) {
                leftMost = mid;     // possible answer
                r = mid - 1;        // search left side
            }
            else if(nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return leftMost;
    }

    private int findRightMost(int[] nums, int target, int n) {

        int l = 0, r = n - 1;
        int rightMost = -1;

        while(l <= r) {

            int mid = l + (r - l) / 2;

            if(nums[mid] == target) {
                rightMost = mid;    // possible answer
                l = mid + 1;        // search right side
            }
            else if(nums[mid] < target) {
                l = mid + 1;
            }
            else {
                r = mid - 1;
            }
        }

        return rightMost;
    }
}