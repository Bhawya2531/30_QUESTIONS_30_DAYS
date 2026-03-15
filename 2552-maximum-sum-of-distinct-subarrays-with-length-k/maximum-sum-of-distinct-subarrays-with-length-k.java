class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
     int l=0;
     long sum=0;
     int r;
     long maxsum=0;
     HashMap<Integer,Integer>map =new HashMap<>();
     for(r=0;r<k;r++){
        map.put(nums[r],map.getOrDefault(nums[r],0)+1);
        sum+=nums[r];
        }
        if(map.size()==k)
        maxsum=sum;
    for(r=k;r<nums.length;r++){
        map.put(nums[r],map.getOrDefault(nums[r],0)+1);
        sum+=nums[r];
        
        sum-=nums[l];
        map.put(nums[l],map.get(nums[l])-1);
        if(map.get(nums[l])==0)
            map.remove(nums[l]);     
        l++;
    
    if(r-l+1==k&&map.size()==k)
        maxsum=Math.max(sum,maxsum);
    }
    
    return maxsum;
}
}