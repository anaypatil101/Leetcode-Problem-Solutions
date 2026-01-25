class Solution {
    public boolean isBipartite(int[][] graph) {
        int u = graph.length;
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0; i<u; i++) {
            adj.add(new ArrayList<>());
        }

        for(int i=0; i<u; i++) {
            for(int j=0; j<graph[i].length; j++) {
                if(graph[i][j] != 0) {
                    adj.get(i).add(graph[i][j]);
                }
            }
        }

      if(u <= 1) return true;
      int[] visited = new int[u];
      Arrays.fill(visited,-1);
      
      for(int i=0; i<u; i++) {
        if(visited[i] == -1) {
            if(!dfs(i,0,visited,adj)) {
                return false;
            }  
        }
      }
      return true;
    }

    private boolean dfs(int cur, int color, int[] visited, List<List<Integer>> adj) {
        visited[cur] = color;

        for(int node : adj.get(cur)) {
            if(visited[node] == -1) {    //if node is not yet coloured
                if(!dfs(node, 1 - color, visited, adj))
                    return false;
            }
            else if(visited[node] == visited[cur])
                return false;
        }
        return true;
    }
}