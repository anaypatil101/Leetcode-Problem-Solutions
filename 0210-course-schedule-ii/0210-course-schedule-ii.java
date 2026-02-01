class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<Integer>[] adj = new ArrayList[numCourses];

        for(int i=0; i<numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        int[] indeg = new int[numCourses];
        //create an adjacency list
        for(int[] pre : prerequisites) {
            int u = pre[0];
            int v = pre[1];
            adj[v].add(u);
            indeg[u]++;
        }

        Queue<Integer> que = new LinkedList<>();        
        for(int i=0; i<numCourses; i++) {
            if(indeg[i] == 0)
                que.offer(i);
        }
        List<Integer> result = new ArrayList<>();

        while(!que.isEmpty()) {
            int curr = que.poll();
            result.add(curr);
            for(int node : adj[curr]) {
                indeg[node]--;

                if(indeg[node] == 0) que.add(node);
            }
        }

        int[] resultArr = new int[result.size()];
        for(int i=0; i<result.size(); i++) {
            resultArr[i] = result.get(i);
        }

        return (resultArr.length == numCourses) ? resultArr : new int[]{};
    }
}