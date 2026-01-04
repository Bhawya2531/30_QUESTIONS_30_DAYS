class Solution {
    public String reversePrefix(String s, int k) {

        StringBuilder sb = new StringBuilder();

        // reverse first k characters
        sb.append(new StringBuilder(s.substring(0, k)).reverse());

        // append remaining string
        sb.append(s.substring(k));

        return sb.toString();
    }
}
