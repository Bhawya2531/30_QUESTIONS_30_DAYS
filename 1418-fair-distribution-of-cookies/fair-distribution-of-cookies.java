class Solution {
    public int distributeCookies(int[] cookies, int k) {
        int children[]=new int[k];
        int result=0;
        return solve(0,cookies,children,k);

    }
        private int solve(int idx, int[]cookies, int[]children, int k){
            int result=Integer.MAX_VALUE;
            int max=0;
            if(idx==cookies.length){
              for(int load:children){
                max=Math.max(max,load);
              }
              return max;
            }
            for(int j=0;j<k;j++){
                children[j]+=cookies[idx];
                int curr=solve(idx+1,cookies,children,k);
                children[j]-=cookies[idx];
                result=Math.min(result,curr);
            }
            return result;
        }
}


               