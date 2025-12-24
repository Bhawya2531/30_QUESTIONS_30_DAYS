class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {

        int count = 0;
        int sum = 0;   // total apples
        int sum2 = 0;  // total box capacity used
        int n = capacity.length;

        // 1️⃣ calculate total apples (THIS WAS MISSING)
        for (int i = 0; i < apple.length; i++) {
            sum += apple[i];
        }

        // 2️⃣ sort capacities
        Arrays.sort(capacity);

        // 3️⃣ pick largest boxes first
        for (int i = n - 1; i >= 0; i--) {
            sum2 += capacity[i];
            count++;

            if (sum2 >= sum) {   // THIS is the stopping condition
                break;
            }
        }

        return count;
    }
}
