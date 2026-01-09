class Solution {
    public String largestEven(String s) {
        int lasttwoindex=-1;
       for(int i=s.length()-1;i>=0;i--){
        if(s.charAt(i)=='2'){
        lasttwoindex=i;
        break;
       }
       }
       if(lasttwoindex==-1){
       return "";
       }
       return s.substring(0,lasttwoindex+1);
    }
}

