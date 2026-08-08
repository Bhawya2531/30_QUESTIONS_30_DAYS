class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->{
            int dista=a[0]*a[0]+a[1]*a[1];
            int distb=b[0]*b[0]+b[1]*b[1];
            return Integer.compare(distb, dista);
        }
        );
        for(int[]point:points){
            pq.offer(point);
            if(pq.size()>k){
                pq.poll();
            }
        }
        int[][]answer=new int[k][2];
        for(int i=0;i<k;i++){
            answer[i]=pq.poll();
        }
        return answer;
    }
}

       