class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums);
        int distinctcount=1;
        int n=nums.length;
        for(int i=n-1;i>0;i--){
          if(nums[i]!=nums[i-1]){
            distinctcount++;
          }
          if(distinctcount==3){
            return nums[i-1];
          }
        }
        return nums[n-1];
    }
}

          