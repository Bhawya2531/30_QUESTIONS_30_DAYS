class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
          int n=grid.length;
          //edge case 
          if(grid[0][0]==1||grid[n-1][n-1]==1) return -1;
          int[][]dirs={{1,0},{-1,0},{0,1},{0,-1},{1,1},{-1,-1},{-1,1},{1,-1}};
          Queue<int[]>q=new LinkedList<>();
          q.offer(new int[]{0,0});
          grid[0][0]=1;//visited
          int pathLength=1;

          while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[]curr=q.poll();
                int r=curr[0], c=curr[1];
                if(r==n-1&&c==n-1){
                    return pathLength;
                }
             for(int[]d:dirs){
                int nr=r+d[0];
                int nc=c+d[1];
                if(nr>=0 && nc>=0 && nr<n && nc<n && grid[nr][nc]==0){
                    q.offer(new int[]{nr,nc});
                    grid[nr][nc]=1;//marl visited
                }
             }
            }
            pathLength++;
          }
          return -1;
    }
}
