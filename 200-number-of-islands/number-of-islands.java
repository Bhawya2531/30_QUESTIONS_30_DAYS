class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int islands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    bfs(i,j,grid,n,m);
                }
            }
        }
        return islands;
    }
public void bfs(int row, int col, char[][]grid, int m, int n){
    Queue<int[]>q=new LinkedList<>();
    grid[row][col]='0';
    q.offer(new int[]{row,col});
    int[] dirrow={-1,0,1,0};
    int[] dircol={0,-1,0,1};
    while(!q.isEmpty()){
        int[]curr=q.poll();
        int r=curr[0];
        int c=curr[1];
        for(int i=0;i<4;i++){
            int nr=r+dirrow[i];
            int nc=c+dircol[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && grid[nr][nc]=='1'){
                grid[nr][nc]='0';
                q.offer(new  int[]{nr,nc});
            }
        }
    }
}
}


    
