class Solution {
    public int numOfSubarrays(int[] arr) {
        int MOD = 1_000_000_007;

        long oddCount = 0;    // number of prefix sums that are odd
        long evenCount = 1;   // empty prefix sum = 0 (even)
        long prefixSum = 0;
        long result = 0;

        for (int num : arr) {
            prefixSum += num;

            if (prefixSum % 2 != 0) {
    result += evenCount;
    oddCount++;
} else {
    result += oddCount;
    evenCount++;
}


            result %= MOD;
        }

        return (int) result;
    }
}
