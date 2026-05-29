class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int start = 0;
        int maxLen = 1;
        // length of substring
        for (int L = 1; L <= n; L++) {
            // starting index
            for (int i = 0; i <= n - L; i++) {
                int j = i + L - 1;
                if (s.charAt(i) == s.charAt(j)) {
                    if (L <= 2) {
                        dp[i][j] = true;
                    }
                    else {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                    // palindrome found
                    if (dp[i][j] && L > maxLen) {
                        start = i;
                        maxLen = L;
                    }
                }
            }
        }

        return s.substring(start, start + maxLen);
    }
}