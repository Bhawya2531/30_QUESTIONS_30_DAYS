class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n=piles.length;
        int left=1;
        int right=0;
        for(int x:piles){
            right=Math.max(x,right);
        }
        while(left<right){
        int mid=left+(right-left)/2;
        if(caneat(piles,h,mid)){
            right=mid;
        }else{// must right else nhi toh left will always change 
        left=mid+1;
        }
        }
        return left;
    }
        boolean caneat(int[]piles,int h, int mid){
            int hours=0;
            for(int p:piles){
            hours+=p/mid;
            if(p%mid!=0) hours++;
            }
            return hours<=h;
        }
}

