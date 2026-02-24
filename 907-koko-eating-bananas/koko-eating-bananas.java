class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int left=1;
        int right=0;
            // find max pile
        for(int x : piles){
            right = Math.max(right, x);
        }
        while(left<right){
            int mid=left+(right-left)/2;
            if(canEatAll(piles,mid,h)){
                right=mid;
            }else{
                left=mid+1;
            }
            }
            return left;
        }
         boolean canEatAll(int[]piles, int mid, int h){
        int actualhours=0;
        for(int x:piles){
            actualhours+=x/mid;
            if(x%mid!=0) {
                actualhours++;
            }
        }
        return actualhours<=h;
    }
    }
