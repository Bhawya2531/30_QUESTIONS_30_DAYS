class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n=nums.length;
        long totalSum=0;
        long rightavg=0;
        for(int i=0;i<nums.length;i++){
            totalSum+=nums[i];
        }
        long leftsum=0;
        long minDifference=Long.MAX_VALUE;
        int resultindx=0;
        for(int i=0;i<n;i++){
            leftsum+=nums[i];
            long leftavg=leftsum/(i+1);
            long rightsum=totalSum-leftsum;
            if(i==n-1){
                rightavg=0;
            }else{
                rightavg=rightsum/(n-i-1);
            }
            long difference=Math.abs(leftavg-rightavg);
            if(difference<minDifference){
            minDifference=difference;
            resultindx=i;
        }
        }

    
return resultindx;
}
}



        