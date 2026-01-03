class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int count=0; 
        int windowsum=0;
        for(int i=0;i<k;i++){
            windowsum+=arr[i];
        }
        if(windowsum>=threshold*k){ 
            count++;
        }
        for(int i=k;i<arr.length;i++){
            windowsum+=arr[i]-arr[i-k];
        
            if(windowsum>=threshold*k) count++;
      
    }
     return count;
}
}

       