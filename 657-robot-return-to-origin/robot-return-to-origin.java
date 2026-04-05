class Solution {
    public boolean judgeCircle(String moves) {
        int start=0;
        int left=0;
        for(int i=0;i<moves.length();i++){
            if(moves.charAt(i)=='U') start++;
            if(moves.charAt(i)=='D') start--;
            if(moves.charAt(i)=='R') left++;
            if(moves.charAt(i)=='L') left--;
        }
          return start==0 && left==0;
        }
    }
