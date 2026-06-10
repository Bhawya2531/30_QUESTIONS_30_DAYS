class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int islands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    dfs(grid,i,j);
                }
            }
        }
        return islands;
    }
   private void dfs(char[][]grid, int r, int c){
    int row=grid.length;
    int col=grid[0].length;
    if(r<0||c<0||r>=row||c>=col){
        return;
    }
    if(grid[r][c]=='0'){
        return;
    }
    grid[r][c]='0'; //mark visited
    dfs(grid,r+1,c);
    dfs(grid,r,c+1);
    dfs(grid,r,c-1);
    dfs(grid,r-1,c);
   }
}

   