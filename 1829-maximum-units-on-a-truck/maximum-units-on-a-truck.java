class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a,b)->b[1]-a[1]);
        int  totalUnits=0;
        //greedy pick
        for(int i=0;i<boxTypes.length && truckSize>0;i++){
            int boxes=boxTypes[i][0];
            int units=boxTypes[i][1];
            int boxesToTake=Math.min(boxes,truckSize);
            totalUnits+=boxesToTake*units;
            truckSize-=boxesToTake;
        }
        return totalUnits;
    }
}
