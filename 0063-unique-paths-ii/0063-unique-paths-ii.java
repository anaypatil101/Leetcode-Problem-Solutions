class Solution {
    public int uniquePathsWithObstacles(int[][] matrix) {
        if(matrix[0][0] == 1) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] prev = new int[n];
        int[] curr = new int[n];

        curr[0] = 1;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0)
                    continue;
                    
                if(matrix[i][j] == 1) {
                    curr[j] = 0;
                    continue;
                }

                int moveUp = 0;
                int moveLeft = 0;
                
                if(i > 0)
                    moveUp = prev[j]; 

                if(j > 0)
                    moveLeft = curr[j - 1];

                curr[j] = moveLeft + moveUp;
            }
            prev = curr;
            curr = new int[n];
        }
        return prev[n - 1];
    }
}