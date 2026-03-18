class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n=nums.length;
        List<Integer>result=new ArrayList<>();
        for(int i=0;i<n;i++){
            int num=Math.abs(nums[i]);
            int idx=num-1;
            if(nums[idx]<0){
                result.add(num);
            }else{
                nums[idx]=-nums[idx];
            }
        }
        return result;
    }
}
