class Solution {
    public int subarraySum(int[] nums, int k) {
       int result=0;
       int prefix=0;
       HashMap<Integer,Integer>map=new HashMap<>();
       map.put(0,1);
       for(int num:nums){
        prefix+=num;
        int oldprefix=prefix-k;
        if(map.containsKey(oldprefix)){
            result+=map.get(oldprefix);        
       }
       map.put(prefix,map.getOrDefault(prefix,0)+1);
       }
       return result;
    }
}

        