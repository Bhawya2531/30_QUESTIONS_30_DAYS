class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n=nums.length;
       int left=1;
       int right=0;
       for(int x:nums){
        right=Math.max(x,right);
       }
       while(left<right){
        int mid=left+(right-left)/2;
        if(candivideall(nums,mid,threshold)){
            right=mid;
        }else{
            left=mid+1;
        }
       }
       return left;
       }
       boolean candivideall(int[]nums, int mid, int threshold){
        int sum=0;
        for(int x:nums){
            sum+=x/mid;
            if(x%mid!=0) sum++;
        }
        return sum<=threshold;
       }
}