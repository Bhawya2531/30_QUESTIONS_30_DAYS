class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int rows = grid2.length;
        int cols = grid2[0].length;
        int count = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    private boolean dfs(int[][] grid1, int[][] grid2, int i, int j) {
        // out of bounds
        if (i < 0 || j < 0 || i >= grid2.length || j >= grid2[0].length) {
            return true;
        }

        // water or already visited
        if (grid2[i][j] == 0) {
            return true;
        }

        // mark visited
        grid2[i][j] = 0;

        // check current cell validity
        boolean isSubIsland = (grid1[i][j] == 1);

        // explore neighbors
        boolean down = dfs(grid1, grid2, i + 1, j);
        boolean up = dfs(grid1, grid2, i - 1, j);
        boolean right = dfs(grid1, grid2, i, j + 1);
        boolean left = dfs(grid1, grid2, i, j - 1);

        return isSubIsland && down && up && right && left;
    }
}
