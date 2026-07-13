class Solution {
    public int[] twoSum(int[] nums, int target) {
       for(int i=0;i<nums.length;i++){
        for(int j=i+1;j<nums.length;j++){
            if(nums[i]+nums[j]==target){
                return new int[]{i,j};
            }
        }
       }
       return new int[]{}; //to forcefully return in[] if we find no correct answer
    }
}
