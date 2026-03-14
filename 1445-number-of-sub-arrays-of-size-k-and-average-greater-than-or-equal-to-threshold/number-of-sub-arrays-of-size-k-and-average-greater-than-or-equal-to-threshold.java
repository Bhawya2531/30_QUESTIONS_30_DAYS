class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum=0;
        int count=0;
        int l=0;
        for(int r=0;r<k;r++){
            sum+=arr[r];
        }
       if(sum >= threshold*k) count++;
        for(int r=k;r<arr.length;r++){
            
                sum+=arr[r];
                sum-=arr[l];
            
            if(sum>=threshold*k) count++;
            l++;
        }
           
            return count;
        }
}
