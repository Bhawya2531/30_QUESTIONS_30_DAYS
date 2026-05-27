class Solution {

    public boolean splitArraySameAverage(int[] nums) {

        int n = nums.length;
        int total = 0;

        // Calculate total sum
        for (int num : nums) {
            total = total + num;
        }

        // dp[count][sum]
        // Can we make sum
        // using exactly count elements?
        boolean[][] dp =
                new boolean[n + 1][total + 1];

        // Base case
        // 0 elements -> sum 0
        dp[0][0] = true;

        // Process each number
        for (int num : nums) {

            // BACKWARD count loop
            for (int count = n - 1;
                 count >= 1;
                 count--) {

                // BACKWARD sum loop
                for (int sum = total;
                     sum >= num;
                     sum--) {

                    // TAKE logic
                    if (dp[count - 1][sum - num] == true) {

                        dp[count][sum] = true;
                    }
                }
            }
        }

        // Try every subset size
        for (int k = 1;
             k <= n / 2;
             k++) {

            // target must be integer
            if ((total * k) % n != 0) {
                continue;
            }

            int target =
                    (total * k) / n;

            // Check answer
            if (dp[k][target] == true) {
                return true;
            }
        }

        return false;
    }
}