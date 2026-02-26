class Solution {

    public int minDays(int[] bloomDay, int m, int k) {

        // IMPOSSIBLE CASE
        if ((long)m * k > bloomDay.length) return -1;

        // search space = days
        int left = Integer.MAX_VALUE;
        int right = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            left = Math.min(left, day);   // earliest bloom
            right = Math.max(right, day); // last bloom
        }

        // binary search for minimum valid day
        while (left < right) {

            int mid = left + (right - left) / 2;

            if (canMakeBouquets(bloomDay, m, k, mid)) {
                right = mid;        // mid can be answer
            } else {
                left = mid + 1;     // need more days
            }
        }

        return left;
    }

    // checking function
    private boolean canMakeBouquets(int[] bloomDay, int m, int k, int day) {

        int bouquets = 0;
        int flowers = 0;

        for (int bloom : bloomDay) {

            // flower bloomed
            if (bloom <= day) {
                flowers++;

                // collected k adjacent flowers
                if (flowers == k) {
                    bouquets++;
                    flowers = 0;   // flowers used, cannot reuse
                }
            }
            // adjacency breaks
            else {
                flowers = 0;
            }
        }

        return bouquets >= m;
    }
}