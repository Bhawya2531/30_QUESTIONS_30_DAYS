class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        solve(0, nums, new ArrayList<>(), result);
        return result;
    }

    private void solve(int index, int[] nums, List<Integer> current, List<List<Integer>> result) {
        // base case
        if (index == nums.length) {
            result.add(current);   // already independent list
            return;
        }

        // 1️⃣ NOT TAKE nums[index]
        solve(index + 1, nums, current, result);

        // 2️⃣ TAKE nums[index]
        List<Integer> take = new ArrayList<>(current);
        take.add(nums[index]);
        solve(index + 1, nums, take, result);
    }
}
