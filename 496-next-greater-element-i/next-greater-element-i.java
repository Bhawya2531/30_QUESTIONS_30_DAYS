class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums2.length;
        Stack<Integer>stack=new Stack<>();
        HashMap<Integer,Integer>map=new HashMap<>();
        
        for(int i=n-1;i>=0;i--){
            int num=nums2[i];

            while(!stack.isEmpty() && stack.peek()<=num){
                stack.pop();
            }
            if(stack.isEmpty()){
                map.put(num,-1);
            }else{
                map.put(num,stack.peek());
            }
            stack.push(num);
        }
         int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }
        
        return ans;
    }
}