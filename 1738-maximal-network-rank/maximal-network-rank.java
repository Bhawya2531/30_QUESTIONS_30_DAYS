class Solution {
    public int maximalNetworkRank(int n, int[][] roads) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        int[]degree=new int[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);

            degree[u]++;
            degree[v]++;
        }
        int maxRank=0;
          // check all pairs
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                
                int rank = degree[i] + degree[j];

                // if directly connected, subtract 1
                if (adj.get(i).contains(j)) {
                    rank--;
                }

                maxRank = Math.max(maxRank, rank);
            }
        }

        return maxRank;
    }
}
   
