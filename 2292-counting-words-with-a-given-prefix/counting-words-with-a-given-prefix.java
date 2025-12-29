class Solution {
    public int prefixCount(String[] words, String pref) {
        return solve(words, pref, 0);
    }
    private int solve(String[] words, String pref, int i){
        if(i==words.length){
            return 0;
        }
        int count=words[i].startsWith(pref) ? 1:0;
        return count+solve(words,pref,i+1);
    }
}

      