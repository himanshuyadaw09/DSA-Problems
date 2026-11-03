class Solution {
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();  // adj list
        for(int i = 0; i < n; i++) adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        for(int i = 0; i < pre.length; i++){
            int a = pre[i][0], b = pre[i][1]; // b->a edge hai
            adj.get(b).add(a); // bth index pe add ko add kar do
            indegree[a]++;
        }
        //kanh's algo
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        int count = 0;
        while(q.size() > 0){
            int front = q.remove();
            count++;
            for(int ele : adj.get(front)){
                indegree[ele]--;
                if(indegree[ele] == 0){
                    q.add(ele);
                }
            }
        }
        if(count != n) return false;
        else return true;

    }
}