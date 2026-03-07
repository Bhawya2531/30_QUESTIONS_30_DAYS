class Solution {
    public boolean checkZeroOnes(String s) {
        int left=0;
        int maxlen=Integer.MIN_VALUE;
        int maxlen2=Integer.MIN_VALUE;
        for(int right=0;right<s.length()-1;right++){
            if(s.charAt(right)=='1' && s.charAt(right+1)=='0'){
            maxlen=Math.max(maxlen,right-left+1);
            left=right+1;
        }
            else if(s.charAt(right)=='0'&& s.charAt(right+1)=='1') {
            maxlen2=Math.max(maxlen2,right-left+1);
            left=right+1;

        }
        }
         // check last segment
        if(s.charAt(s.length()-1) == '1')
            maxlen = Math.max(maxlen, s.length() - left);
        else
            maxlen2 = Math.max(maxlen2, s.length() - left);

        return maxlen > maxlen2;
       
        }
    }
