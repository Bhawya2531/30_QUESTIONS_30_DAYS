class Pair{
    int node;
    double prob;
    Pair(int node, double prob){
        this.node=node;
        this.prob=prob;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double p=succProb[i];
            adj.get(u).add(new Pair(v,p));
            adj.get(v).add(new Pair(u,p));
        }
        double[]prob=new double[n];
        Arrays.fill(prob,0.0);
        prob[start_node]=1.0;
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Double.compare(b.prob,a.prob));
        pq.add(new Pair(start_node,1.0));
        while(!pq.isEmpty()){
            Pair curr=pq.poll();
            int node=curr.node;
            double p=curr.prob;
            if(node==end_node) return p; //what if start node is end node
            if(p<prob[node]) continue;
           for(Pair nbr:adj.get(node)){
            int next=nbr.node;
            double newProb=p*nbr.prob; //since we are maximizing this
            if(newProb>prob[next]){
                prob[next]=newProb;
                pq.add(new Pair(next,newProb));
            }
           }
        }
        return 0.0;
    }
}
           