class Solution {
    public String makeFancyString(String s) {
        return helper(s, 0, new StringBuilder()).toString();
    }

    private StringBuilder helper(String s, int i, StringBuilder result) {
        // base case
        if (i == s.length()) {
            return result;
        }

        int n = result.length();

        // check last two characters
        if (n >= 2 &&
            result.charAt(n - 1) == s.charAt(i) &&
            result.charAt(n - 2) == s.charAt(i)) {

            // skip current character
            return helper(s, i + 1, result);
        }

        // take current character
        result.append(s.charAt(i));
        return helper(s, i + 1, result);
    }
}
