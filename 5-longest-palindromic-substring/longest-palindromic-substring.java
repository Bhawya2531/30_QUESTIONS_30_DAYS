class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        int[][]dp=new int[n][n];
        int maxlen=Integer.MIN_VALUE;
        int sp=0;

        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                if(isPalindrome(s,i,j)){
                    if(j-i+1>maxlen){
                        maxlen=j-i+1;
                        sp=i;
                    }
                }
            }
        }
        return s.substring(sp,sp+maxlen);
    }
    boolean isPalindrome(String s, int i, int j){
        if(i>=j) return true;
        if(s.charAt(i)==s.charAt(j)){
            return isPalindrome(s, i+1, j-1);
        }
        return false;
    }
}

       