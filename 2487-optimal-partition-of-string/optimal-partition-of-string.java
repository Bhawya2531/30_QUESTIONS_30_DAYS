class Solution {
    public int partitionString(String s) {
        int[] lastSeen = new int[26];

        // initialize with -1 (means not seen yet)
        for (int i = 0; i < 26; i++) {
            lastSeen[i] = -1;
        }

        int count = 0;
        int currSubstrStart = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // if character was seen in current substring
            if (lastSeen[ch - 'a'] >= currSubstrStart) {
                count++;                 // close current substring
                currSubstrStart = i;     // start new substring
            }

            lastSeen[ch - 'a'] = i;      // update last seen index
        }

        return count + 1; // last substring
    }
}
