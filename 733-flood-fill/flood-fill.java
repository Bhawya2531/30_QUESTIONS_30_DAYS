class Solution {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int original = image[sr][sc];

        if(original == color) {
            return image;
        }

        int n = image.length;
        int m = image[0].length;

        bfs(sr, sc, image, original, color, n, m);

        return image;
    }

    public void bfs(int row, int col, int[][] image,
                    int original, int color,
                    int n, int m) {

        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{row, col});

        image[row][col] = color;

        int[] dirrow = {-1, 0, 1, 0};
        int[] dircol = {0, -1, 0, 1};

        while(!q.isEmpty()) {

            int[] curr = q.poll();

            int r = curr[0];
            int c = curr[1];

            for(int i = 0; i < 4; i++) {

                int nr = r + dirrow[i];
                int nc = c + dircol[i];

                if(nr >= 0 && nr < n &&
                   nc >= 0 && nc < m &&
                   image[nr][nc] == original) {

                    image[nr][nc] = color;

                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}