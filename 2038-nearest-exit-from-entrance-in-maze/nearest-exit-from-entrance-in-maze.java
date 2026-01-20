class Solution {
    int[][]directions={{0,1},{0,-1},{1,0},{-1,0}};
    public int nearestExit(char[][]maze,int[]entrance){
        int m=maze.length;
        int n=maze[0].length;

        Queue<int[]>queue=new LinkedList<>();
        queue.offer(new int[]{entrance[0],entrance[1]});
        maze[entrance[0]][entrance[1]]='+';
        int steps=0;
        while(!queue.isEmpty()){
            int size=queue.size();
            while(size-->0){
                int[]temp=queue.poll();
                int i=temp[0];
                int j=temp[1];
                if(!(i==entrance[0]&&j==entrance[1])&&(i==0||j==0||i==m-1||j==n-1)){
                    return steps;
                }
                for(int[]dir:directions){
                    int new_i=i+dir[0];
                    int new_j=j+dir[1];
                    if(new_i>=0&&new_i<m &&
                       new_j>=0&&new_j<n &&
                       maze[new_i][new_j]=='.'){
                        queue.offer(new int[]{new_i,new_j});
                        maze[new_i][new_j]='+';
                       }
                }
            }
            steps++;
        }
        return -1;
    }
    }