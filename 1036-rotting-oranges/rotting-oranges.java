class Solution {
    public int orangesRotting(int[][] grid) {
        Queue<int[]>q=new LinkedList<>();
        int fresh=0;
        int time=0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int[][] dirs={{1,0},{-1,0},{0,1},{0,-1}};
        while(!q.isEmpty() && fresh>0){
            int size=q.size();
            for(int i=0;i<size;i++){
            int[]cell=q.poll();
            for(int[]d:dirs){
                int ni=cell[0]+d[0];
                int nj=cell[1]+d[1];
                if(ni>=0 && nj>=0 && ni<m && nj<n && grid[ni][nj]==1){
                    grid[ni][nj]=2;
                    fresh--;
                    q.offer(new int[]{ni,nj});
                }
            }
            }
            time++;
        }
        return fresh==0? time:-1;
    }
}
