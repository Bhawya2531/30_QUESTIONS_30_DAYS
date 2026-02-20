class Solution {

    public boolean check(int[] nums) {

        int n = nums.length;

        // try every rotation
        for(int k = 0; k < n; k++){

            int[] rotated = new int[n];

            // build rotated array
            for(int i = 0; i < n; i++){
                rotated[i] = nums[(i + k) % n];
            }

            // check if sorted
            if(isSorted(rotated))
                return true;
        }

        return false;
    }

    private boolean isSorted(int[] arr){
        for(int i = 0; i < arr.length-1; i++){
            if(arr[i] > arr[i+1])
                return false;
        }
        return true;
    }
}