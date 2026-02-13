import java.util.*;

class Solution {
    public int mostFrequentEven(int[] nums) {

        HashMap<Integer, Integer> map = new HashMap<>();

        // Step 1: Count frequency of even numbers
        for (int num : nums) {
            if (num % 2 == 0) {
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }

        int maxFreq = 0;
        int result = -1;

        // Step 2: Find most frequent even (smallest if tie)
        for (int key : map.keySet()) {
            int freq = map.get(key);

            if (freq > maxFreq || 
               (freq == maxFreq && key < result)) {

                maxFreq = freq;
                result = key;
            }
        }

        return result;
    }
}
