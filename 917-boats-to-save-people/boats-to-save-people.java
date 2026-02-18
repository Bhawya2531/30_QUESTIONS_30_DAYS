class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int i=0;
        int j=people.length-1;
        int boats=0;
        while(i<=j){
            if(people[i]+people[j]<=limit){ //try to pair lightest with heaviest
                i++;                        //light person also goes
            }
            //heaviest always goes
            j--;
            boats++;
        }
        return boats;
    }
}
