class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[]diff=new int[n+2];
        for(int[] b:bookings){
            int start=b[0];
            int end=b[1];
            int count=b[2];

            diff[start]+=count;
            diff[end+1]-=count;

        }
        List<Integer>result=new ArrayList<>();
        int cumsum=0;
        for(int i=1;i<=n;i++){
            cumsum+=diff[i];
            result.add(cumsum);
        }
        int[]ans=new int[result.size()];
        for(int i=0;i<result.size();i++){
            ans[i]=result.get(i);
        }
    
        return ans ;
    }
}

        