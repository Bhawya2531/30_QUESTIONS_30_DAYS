import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        int n = nums.length;
        int[] ans = new int[k];
        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency
        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // Step 2: Store frequencies in array
        int[] freq = new int[map.size()];
        int index = 0;

        for (int value : map.values()) {
            freq[index++] = value;
        }

        // Step 3: Sort frequencies
        Arrays.sort(freq);

        // Step 4: Pick top k frequencies
        int count = 0;

        for (int i = freq.length - 1; i >= 0 && count < k; i--) {
            int currentFreq = freq[i];

            for (int key : map.keySet()) {
                if (map.get(key) == currentFreq) {
                    ans[count++] = key;
                    map.put(key, -1); // mark used to avoid duplicates
                    break;
                }
            }
        }

        return ans;
    }
}
