class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxFreq = 0;   // max frequency of a single char in window
        int maxLength = 0;

        for (int right = 0; right < s.length(); right++) {
            char r = s.charAt(right);

            // Add current character
            map.put(r, map.getOrDefault(r, 0) + 1);

            // Update max frequency
            maxFreq = Math.max(maxFreq, map.get(r));

            // Check if window is invalid
            while ((right - left + 1) - maxFreq > k) {
                char l = s.charAt(left);

                // Remove left character
                map.put(l, map.get(l) - 1);
                left++;
            }

            // Update answer
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}