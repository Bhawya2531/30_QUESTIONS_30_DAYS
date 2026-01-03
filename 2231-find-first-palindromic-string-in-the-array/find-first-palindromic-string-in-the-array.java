class Solution {
    public String firstPalindrome(String[] words) {
        for(String word:words){
            if (isPalindrome(word, 0, word.length()-1)){
                return word;
            

        }
    }
    return "";
}
private boolean isPalindrome(String s, int left, int right){
    if(left>=right) return true;
    if(s.charAt(left)!=s.charAt(right)) return false;
    return isPalindrome(s, left+1, right-1);
}
}
    

        