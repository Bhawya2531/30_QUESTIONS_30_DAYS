class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int i=0;
        int j=piles.length-1;
        int ans=0;
        while(i<j){
            j--;
            ans+=piles[j];
            j--;
            i++;
        }
        return ans;
        
    }
}