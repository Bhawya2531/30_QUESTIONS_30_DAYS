
       class Solution {
    public int countSubstrings(String s) {

        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int i = n - 1; i >= 0; i--) {

            for (int j = i; j < n; j++) {

                // first and last character must match
                if (s.charAt(i) == s.charAt(j)) {

                    // length 1 or 2
                    if (j - i <= 1) {
                        dp[i][j] = true;
                    }

                    // length > 2
                    else if (dp[i + 1][j - 1]) {
                        dp[i][j] = true;
                    }
                }

                if (dp[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}