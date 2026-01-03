class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        ArrayList<Integer>list=new ArrayList<>();
        for(int i=0; i<nums.length;i++){
            list.add(nums[i]);
        }
        for(int i=0; i<nums.length;i++){
            list.add(nums[i]);
        }
        int[] arr = new int[2*n];
         for (int i = 0; i < 2*n; i++) {
         arr[i] = list.get(i);
}
return arr;


    }
}