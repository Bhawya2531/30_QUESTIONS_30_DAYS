class Solution {
    public int minimumCost(int[] cost) {

        Arrays.sort(cost);

        int total = 0;
        int count = 0;

        // traverse from largest to smallest
        for(int i = cost.length - 1; i >= 0; i--){

            count++;

            // every 3rd candy is free
            if(count % 3 != 0){
                total += cost[i];
            }
        }

        return total;
    }
}
