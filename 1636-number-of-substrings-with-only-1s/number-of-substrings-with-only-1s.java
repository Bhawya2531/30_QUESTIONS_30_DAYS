class Solution {
    public int numSub(String s) {
        long count=0;
        long streak=0;
        int mod=1000000007;
       for(char ch:s.toCharArray()){
            if(ch=='1'){
                streak++;
              count+=streak;
            }else{
                streak=0;
            }
        }
        return (int)(count%mod);
    }
}