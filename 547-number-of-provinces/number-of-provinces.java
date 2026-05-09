class Solution {
    public int findCircleNum(int[][] isConnected) {

        int n = isConnected.length;
        int provinces = 0;

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                provinces++;

                bfs(i, isConnected, visited);
            }
        }

        return provinces;
    }

    private void bfs(int start, int[][] isConnected, boolean[] visited) {

        Queue<Integer> q = new LinkedList<>();

        visited[start] = true;
        q.offer(start);

        while (!q.isEmpty()) {

            int node = q.poll();

            for (int neighbor = 0; neighbor < isConnected.length; neighbor++) {

                if (isConnected[node][neighbor] == 1 && !visited[neighbor]) {

                    visited[neighbor] = true;

                    q.offer(neighbor);
                }
            }
        }
    }
}