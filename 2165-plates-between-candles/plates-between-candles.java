class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n=s.length();
        int[]prefix=new int[n];
        if(s.charAt(0)=='*'){
        prefix[0]=1;
     }else{ 
            prefix[0]=0;
}
        for(int i=1;i<n;i++){
           prefix[i]=prefix[i-1];
           if(s.charAt(i)=='*'){
            prefix[i]++;
           }
        }
        int[]leftcandle=new int[n];
        int last=-1;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='|'){
                last=i;
            }
            leftcandle[i]=last;
        }
        int[]rightcandle=new int[n];
        last=-1;
        for(int i=n-1;i>=0;i--){
            if(s.charAt(i)=='|'){
                last=i;
            }
            rightcandle[i]=last;
        }
        int[]ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            
            int start=rightcandle[l];
            int end=leftcandle[r];

            if(start==-1||end==-1||start>=end){
                ans[i]=0;
            }else{
                ans[i]=prefix[end]-prefix[start];
            }
        }
        return ans;
    }
}
