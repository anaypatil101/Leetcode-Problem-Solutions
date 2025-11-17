class Solution {
    public int numEnclaves(int[][] grid) {
        int[][] mat = new int[grid.length][grid[0].length];
        for(int i=0; i<grid.length; i++) {
            mat[i] = Arrays.copyOf(grid[i],grid[i].length);
        }
        int m = mat.length;
        int n = mat[0].length;
        boolean[][] visited = new boolean[m][n];
        
        for(int i=0; i<n; i++) {
            //for first row and last row
            if(mat[0][i] == 1) dfs(0,i,mat,visited,m,n);
            if(mat[m-1][i] == 1) dfs(m-1,i,mat,visited,m,n);
        }

        for(int i=0; i<m; i++) {
            //for first col and last col
            if(mat[i][0] == 1) dfs(i,0,mat,visited,m,n);
            if(mat[i][n-1] == 1) dfs(i,n-1,mat,visited,m,n); 
        }
        int ans = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && mat[i][j] == 1)
                    ans++;
            }
        }
        return ans;
    }

    private void dfs(int i, int j, int[][] mat, boolean[][] visited,int m, int n) {
        if(i < 0 || i >= m || j < 0 || j >= n || mat[i][j] == 0 || visited[i][j])  
            return;
        
        visited[i][j] = true;
        int[] delrow = {-1,1,0,0};
        int[] delcol = {0,0,-1,1};

        for(int num=0; num<4; num++) {
            int nrow = i + delrow[num];
            int ncol = j + delcol[num];

            dfs(nrow,ncol,mat,visited,m,n);
        }
    }
}