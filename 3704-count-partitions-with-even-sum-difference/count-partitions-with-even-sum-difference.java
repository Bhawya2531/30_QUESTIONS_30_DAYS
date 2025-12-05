class Solution {
    public int countPartitions(int[] nums) {
        int totalsum=0;
        int count=0;
        int leftsum=0;
        for(int i=0;i<nums.length;i++){
            totalsum+=nums[i];    
        }
        for(int i=0;i<nums.length-1;i++){
            leftsum+=nums[i];
            if((leftsum-(totalsum-leftsum))%2==0){
                count++;
            }
        }
        return count;
    }
}