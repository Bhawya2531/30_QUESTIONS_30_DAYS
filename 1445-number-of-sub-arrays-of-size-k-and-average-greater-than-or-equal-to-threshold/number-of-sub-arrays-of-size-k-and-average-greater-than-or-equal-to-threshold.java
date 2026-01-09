class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count=0; 
        int windowsum=0;
        int left=0;
        int avg=0;
     
        for(int right=0;right<arr.length;right++){
            windowsum+=arr[right];
            if(right-left+1==k){
                if(windowsum>=threshold*k){
                    count++;
                }
              
                windowsum-=arr[left];
                left++;
            }
        }
          
        return count;
    }
}