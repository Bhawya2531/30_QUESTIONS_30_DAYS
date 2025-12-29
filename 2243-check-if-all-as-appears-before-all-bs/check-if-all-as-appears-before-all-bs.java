class Solution {
    public boolean checkString(String s) {
        return helper(s, 0, false);
    }

    private boolean helper(String s, int index, boolean seenB) {
        // base case
        if (index == s.length()) return true;

        char ch = s.charAt(index);

        // invalid case: 'a' after 'b'
        if (ch == 'a' && seenB) return false;

        // update state if 'b' is seen
        if (ch == 'b') seenB = true;

        // recursive call
        return helper(s, index + 1, seenB);
    }
}
