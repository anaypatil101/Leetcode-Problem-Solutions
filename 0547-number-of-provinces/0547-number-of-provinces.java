class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();    //adjacency list
        for(int i=0; i<n; i++) {
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i != j && isConnected[i][j] == 1) {
                    adj.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int ans = 0;
        for(int i=0; i<n; i++) {
            if(!visited[i]) {
                dfs(i, visited, adj);
                ans++;
            }
        }
        
        return ans;
    }

    private void dfs(int node, boolean[] visited, List<List<Integer>> adj) {
        visited[node] = true;
        for(int curr : adj.get(node)) {
            if(!visited[curr])
                dfs(curr, visited, adj);
        }
    }
}