class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left=1;
        int right=0;
        for(int x:nums){
            right=Math.max(right,x);
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if (divisorgroup(nums,mid,threshold)){
                right=mid;
            }else{
                left=mid+1;
            }
        }
        return left;
    }
    boolean divisorgroup(int[] nums, int divisor, int threshold){
        int result=0;
        for(int x:nums){
            result+=x/divisor;
            if(x%divisor!=0) result++;
        }
        return result<=threshold;
    }
}