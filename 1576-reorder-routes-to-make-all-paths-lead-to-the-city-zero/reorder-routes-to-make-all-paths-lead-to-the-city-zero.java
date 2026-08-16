class Solution {
    static class Edge{
        int to;
        int cost;
        Edge(int to, int cost){
            this.to=to;
            this.cost=cost;
        }
    }
    public int minReorder(int n, int[][] connections) {
        List<List<Edge>>graph=new ArrayList<>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
        }
        for(int[]connection:connections){
            int from=connection[0];
            int to=connection[1];
            graph.get(from).add(new Edge(to,1)); //original diretion
            graph.get(to).add(new Edge(from,0)); //fake reverse 
        }
        boolean[]visited=new boolean[n];
        return dfs(0,graph,visited);
    }
    private int dfs(int node, List<List<Edge>>graph, boolean[]visited){
        visited[node]=true;
        int count=0;
        for(Edge edge:graph.get(node)){
            if(visited[edge.to]){
                continue;
            }
            count+=edge.cost;
            count+=dfs(edge.to,graph,visited);
        }
        return count;
    }
}

       