class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        if(src == dst) return 0;
        //build adj list
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0; i<n; i++) adj.add(new ArrayList<>());

        for(int i=0; i<flights.length; i++) {
            int u = flights[i][0];
            int v = flights[i][1];
            int wt = flights[i][2];
            adj.get(u).add(new int[]{v,wt});
        }
        Queue<int[]> que = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        que.offer(new int[]{0,src,0});

        while(!que.isEmpty()) {
            int[] arr = que.poll();
            int stops = arr[0];
            int node = arr[1];
            int wt = arr[2];

            if(stops > K) continue;

            //traverse all the neighbours
            for(int[] neighbour : adj.get(node)) {
                int adjNode = neighbour[0];
                int edgeWt = neighbour[1];

                if(wt + edgeWt < dist[adjNode]) {
                    dist[adjNode] = wt + edgeWt;
                    que.offer(new int[]{stops + 1, adjNode, dist[adjNode]});
                }
            }
        }
        if(dist[dst] == Integer.MAX_VALUE) 
            return -1;
            
        return dist[dst];
    }
}

