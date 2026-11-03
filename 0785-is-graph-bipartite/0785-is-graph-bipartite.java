class Solution {
    static boolean ans; // global variable
    private void bfs(int i, int[] visited, int[][] adj){
        visited[i] = 0; // 0 -> blue and 1 -> red
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        while(!q.isEmpty()){
            int front = q.poll();
            int color = visited[front];
            for(int ele : adj[front]){
                if(visited[ele] == visited[front]){
                    ans = false;
                    return;
                }
                if(visited[ele] == -1){
                    visited[ele] = 1 - color;
                    q.add(ele);
                }
            }
        }
    }
    public boolean isBipartite(int[][] graph) {
        ans = true;
        int n = graph.length;
        int[] visited = new int[n];
        Arrays.fill(visited, -1); // fill arrays with -1 means starting with no color
        for(int i = 0; i < n; i++){
            if(ans == false) return false;
            if(visited[i] == -1) bfs(i, visited, graph);
        }
        return ans;
    }
}