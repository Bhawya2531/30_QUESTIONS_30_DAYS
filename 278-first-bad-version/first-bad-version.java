/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;

        while(left < right){

            int mid = left + (right - left) / 2;

            if(isBadVersion(mid)){
                // mid could be the answer
                right = mid;
            } 
            else{
                // answer is strictly right side
                left = mid + 1;
            }
        }

        return left;
    }
}