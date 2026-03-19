class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for(int[] arr : dp)
            Arrays.fill(arr, -1);

        dp[0][0] = 1;

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }

                int moveUp = 0;
                int moveLeft = 0;

                if(i > 0) 
                    moveUp = dp[i - 1][j];
                if(j > 0)
                    moveLeft = dp[i][j - 1];
                    
                dp[i][j] = moveUp + moveLeft;
            }
        }
        return dp[m - 1][n - 1];
    }
}