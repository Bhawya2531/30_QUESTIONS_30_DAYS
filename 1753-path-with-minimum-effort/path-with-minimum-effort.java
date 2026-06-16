class Solution {
    public int minimumEffortPath(int[][] heights) {
       int m=heights.length;
       int n=heights[0].length;
       int [][]dirs={{-1,0},{1,0},{0,1},{0,-1}};
       int[][]effort=new int[m][n];
       for(int[]row:effort) Arrays.fill(row,Integer.MAX_VALUE);
       effort[0][0]=0;
       PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
       pq.add(new int[]{0,0,0,});
       while(!pq.isEmpty()){
        int[] curr=pq.poll();
        int currEff=curr[0];
        int r=curr[1];
        int c=curr[2];
        if(r==m-1 && c==n-1)  return currEff;
        for(int[]d:dirs){
            int nr=r+d[0];
            int nc=c+d[1];
            if(nr>=0 && nr<m && nc>=0 && nc<n){
                int diff = Math.abs(heights[r][c] - heights[nr][nc]);
                    int newEffort = Math.max(currEff, diff);

                    if (newEffort < effort[nr][nc]) {
                        effort[nr][nc] = newEffort;
                        pq.add(new int[]{newEffort, nr, nc});
                    }
                }
            }
        }

        return 0; // should never reach he

            }

        }



      