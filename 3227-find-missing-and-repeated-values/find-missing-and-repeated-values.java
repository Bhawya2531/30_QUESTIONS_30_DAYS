class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int[]ans=new int[2];
        HashMap<Integer,Integer>map=new HashMap<>();
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(map.containsKey(grid[i][j])){
                    ans[0]=grid[i][j];
                }
                map.put(grid[i][j],map.getOrDefault(grid[i][j],0)+1);
            }
        }
        Integer[] arr = map.keySet().toArray(new Integer[0]);
        Arrays.sort(arr);
        int i;
        for( i=1;i<arr.length;i++){
            if(arr[i]-arr[i-1]==2) 
           ans[1]=arr[i]-1;
        }
        if(ans[1]==0){
        if(arr[0]!=1) ans[1]=1;
        else ans[1]=grid.length*grid.length;
        }
        return ans;
    }
}

        