class Solution {
    void dfs(int[][]stones,int index,boolean[]visited){
    visited[index]=true;  //this already belongs to some group

    int r=stones[index][0];
    int c=stones[index][1];
    for(int i=0;i<stones.length;i++){
        if(!visited[i]){
            if(stones[i][0]==r||stones[i][1]==c){
                dfs(stones,i,visited);
            }
        }
    }


}
    public int removeStones(int[][] stones) {
       int n=stones.length;
       boolean[]visited=new boolean[n];
       int groups=0;
       for(int i=0;i<n;i++){
        if(!visited[i]){
            dfs(stones,i,visited);
            groups++;
        }
       }
       return n-groups;
    }
}
