class Solution {
    public String mergeAlternately(String word1, String word2) {
       return helper(word1, word2, 0);
    }
    private String helper(String w1, String w2, int i){
        //Base case: Both String Exhausted
        if(i>=w1.length() && i>=w2.length()){
            return "";
        }
        String result="";
        if(i<w1.length()){
            result+=w1.charAt(i);
        }
        if(i<w2.length()){
            result+=w2.charAt(i);
        }
        return result+helper(w1,w2,i+1);
    }
}