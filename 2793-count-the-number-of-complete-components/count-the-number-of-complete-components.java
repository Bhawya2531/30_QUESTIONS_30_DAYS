class Solution {
    int nodes=0;
    int degreesum=0;
    public int countCompleteComponents(int n, int[][] edges) {
        int answer=0;
        boolean[]visited=new boolean[n];
            List<List<Integer>>adj=new ArrayList<>();
            for(int i=0;i<n;i++){
                adj.add(new ArrayList<>());
            }
                for(int[]edge:edges){
                int u=edge[0];
                int v=edge[1];
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            for(int i=0;i<n;i++){
            if(!visited[i]){
            nodes=0;
            degreesum=0;
            bfs(adj,i,visited,n);
            int componentedges=degreesum/2;
            if(componentedges==nodes*(nodes-1)/2){
            answer++;
            }
        }
            }
            return answer;
            }
            private void bfs(List<List<Integer>>adj, int start, boolean[]visited,int n){
                Queue<Integer>q=new LinkedList<>();
                q.offer(start);
                while(!q.isEmpty()){
                int node=q.poll();
                if(visited[node]) continue;
                visited[node]=true;
                nodes++;
                degreesum+=adj.get(node).size();
                for(int neighbor:adj.get(node)){
                    if(!visited[neighbor]){
                        q.offer(neighbor);
                    }
                }
                }
            }
}


            
          