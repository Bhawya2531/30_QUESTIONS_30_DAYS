class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
       

        int[] diff = new int[1001];

        for(int[] p : trips){
            int passengers = p[0];
            int from = p[1];
            int to = p[2];

            diff[from] += passengers;
            diff[to] -= passengers;
        }

        int sum = 0;

        for(int i = 0; i <= 1000; i++){
            sum += diff[i];

            if(sum > capacity){
                return false;
            }
        }

        return true;
    }
}