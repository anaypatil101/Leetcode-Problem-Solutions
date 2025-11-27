class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        int minutes = 0, fresh = 0;
        //find rotten oranges and offer in queue
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 2) 
                    q.offer(new int[]{i,j});
                if(grid[i][j] == 1)
                    fresh++;
            }
        }
        if(fresh == 0) return 0;    //no fresh oranges, so no need to rot them
        boolean didRot = false;
        int[] delRow = {0,0,-1,1};
        int[] delCol = {-1,1,0,0};    
        while(!q.isEmpty()) {
            didRot = false;
            int len = q.size();
            for(int i=0; i<len; i++) {
                int row = q.peek()[0];
                int col = q.peek()[1];
                q.poll();

                //explore, mark as rotten and push into queue
                for(int k=0; k<4; k++) {
                    int nrow = row + delRow[k];
                    int ncol = col + delCol[k];

                    if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;   //make it rotten
                        q.offer(new int[]{nrow,ncol}); //queue entry
                        didRot = true;
                        fresh--;
                    }
                }
            }
            if(didRot) minutes++;
        }

        //if all oranges not rotten, then return -1 otherwise return minutes
        if(fresh > 0) 
            return -1;
        else
            return minutes;
    }
}