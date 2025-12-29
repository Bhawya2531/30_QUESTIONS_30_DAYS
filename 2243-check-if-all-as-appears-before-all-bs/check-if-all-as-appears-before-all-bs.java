class Solution {
    public boolean checkString(String s) {

        // If "ba" is found, then a 'b' is followed by 'a' → invalid
        return !s.contains("ba");
    }
}
