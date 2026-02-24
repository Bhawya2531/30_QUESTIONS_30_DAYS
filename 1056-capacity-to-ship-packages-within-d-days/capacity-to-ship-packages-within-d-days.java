class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int n=weights.length;
        int left=0;
        int right=0;
        for(int x:weights){
            left=Math.max(left,x);
            right+=x;
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if (canshipAll(weights,mid,days)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;

    }
    boolean canshipAll(int[]weights, int capacity, int days){
        int useddays=1;
        int currentload=0;
        for(int x:weights){
            if(currentload+x>capacity) {useddays++;
            currentload=0;
        }
        currentload+=x;
        }
        return useddays<=days;
    }
}
