import java.util.*;

class Solution {
    public int maxIceCream(int[] costs, int coins) {

        Arrays.sort(costs);

        int count = 0;

        for(int i = 0; i < costs.length; i++){

            if(costs[i] <= coins){
                coins -= costs[i]; // pay money
                count++;           // bought ice cream
            }
            else
                break; // cannot afford further (prices only increase)
        }

        return count;
    }
}
