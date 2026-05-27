class Solution {

    public boolean splitArraySameAverage(int[] nums) {

        int n = nums.length;
        int total = 0;

        // Calculate total sum
        for (int num : nums) {
            total = total + num;
        }

        // dp[i][count][sum]
        // Using first i elements,
        // can we make sum
        // using exactly count elements?
        boolean[][][] dp =
                new boolean[n + 1][n + 1][total + 1];

        // Base case
        // Using 0 elements,
        // making sum 0
        // with 0 picked elements
        dp[0][0][0] = true;

        // Process elements one by one
        for (int i = 1; i <= n; i++) {

            int num = nums[i - 1];

            // count = how many picked
            for (int count = 0; count <= i; count++) {

                // sum = target sum
                for (int sum = 0; sum <= total; sum++) {

                    // ---------- NOT TAKE ----------

                    dp[i][count][sum]
                            = dp[i - 1][count][sum];

                    // ---------- TAKE ----------

                    if (count > 0 && sum >= num) {

                        if (dp[i - 1][count - 1][sum - num] == true) {

                            dp[i][count][sum] = true;
                        }
                    }
                }
            }
        }

        // Try every subset size
        for (int k = 1; k <= n / 2; k++) {

            // target must be integer
            if ((total * k) % n != 0) {
                continue;
            }

            int target = (total * k) / n;

            // Can we make target using exactly k elements?
            if (dp[n][k][target] == true) {
                return true;
            }
        }

        return false;
    }
}
       