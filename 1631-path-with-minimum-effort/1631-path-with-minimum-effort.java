class Solution {
    int[] drow = {1,0,-1,0};
    int[] dcol = {0,1,0,-1};
    public int minimumEffortPath(int[][] heights) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );
        int n = heights.length;
        int m = heights[0].length;

        int[][] maxDiff = new int[n][m];
        for(int[] row : maxDiff) 
            Arrays.fill(row,Integer.MAX_VALUE);
        
        maxDiff[0][0] = 0;
        pq.add(new int[]{0,0,0});
        
        while(!pq.isEmpty()) {
            int[] ele = pq.poll();

            int diff = ele[0];
            int row = ele[1];
            int col = ele[2];

            if(row == n -1 && col == m - 1)
                return diff;

            for(int i=0; i<4; i++) {
                int newRow = row + drow[i];
                int newCol = col + dcol[i];

                if(isValid(newRow, newCol, n, m)) {
                    int currDiff = Math.abs(heights[row][col] - heights[newRow][newCol]);

                    if(Math.max(currDiff,diff) < maxDiff[newRow][newCol]) {
                        maxDiff[newRow][newCol] = Math.max(currDiff,diff);
                        pq.add(new int[]{Math.max(diff, currDiff),newRow,newCol});
                    }
                }
            }
        }
        return -1;
    }
    private boolean isValid(int i, int j, int n, int m) {
        if(i >= 0 && i < n && j >= 0 && j < m)
            return true;
        
        return false;
    }
}