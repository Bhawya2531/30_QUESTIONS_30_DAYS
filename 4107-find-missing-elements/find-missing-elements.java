class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        List<Integer>list=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
            int curr=nums[i]+1;
            while(curr<nums[i+1]){
                list.add(curr);
                curr++;
            }
        }
        return list;
    }
}
