class Solution {
    public boolean search(int[] nums, int target) {
        int low=0; int high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            for(int i=0;i<nums.length;i++){
                if(mid<target) low++;
                else high--;
            
            if(nums[i]==target) return true;
        }
        }
        return false;
    }
}