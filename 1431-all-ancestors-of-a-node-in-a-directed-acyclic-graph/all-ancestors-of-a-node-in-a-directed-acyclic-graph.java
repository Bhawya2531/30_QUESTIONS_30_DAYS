class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[]indegree=new int[n];
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);

            indegree[v]++;
        }
          // ancestors[i] will store all ancestors of node i
        List<Set<Integer>> ancestors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ancestors.add(new HashSet<>());
        }
        
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        while (!q.isEmpty()) {
            int u = q.poll();

            for (int v : adj.get(u)) {
                // add u as ancestor
                ancestors.get(v).add(u);
                // add all ancestors of u
                ancestors.get(v).addAll(ancestors.get(u));

                indegree[v]--;
                if (indegree[v] == 0) {
                    q.offer(v);
                }
            }
        }

        // Convert sets to sorted lists
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> list = new ArrayList<>(ancestors.get(i));
            Collections.sort(list);
            result.add(list);
        }

        return result;
    }
}
