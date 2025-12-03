class Solution {
    public int maxDistinct(String s) {
        boolean[] used = new boolean[26];
        int count = 0;

        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (!used[idx]) {
                used[idx] = true;
                count++;
            }
        }

        return count;
    }
}
