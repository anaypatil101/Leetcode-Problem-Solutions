class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalColor = image[sr][sc];

        if(originalColor == color) return image;
    
        dfs(sr,sc,image,color,originalColor);
        return image;
    }

    private void dfs(int row, int col, int[][] image, int color,int originalColor) {
        image[row][col] = color;
        int n = image.length;
        int m = image[0].length;


        if(col - 1 >= 0 && image[row][col-1] != color && image[row][col-1] == originalColor) 
            dfs(row,col-1,image, color,originalColor);
        
        if(row - 1 >= 0 && image[row-1][col] != color && image[row-1][col] == originalColor)
            dfs(row-1, col, image, color,originalColor);

        if(col + 1 < m && image[row][col+1] != color && image[row][col+1] == originalColor)
            dfs(row, col+1, image, color,originalColor);
        
        if(row + 1 < n && image[row+1][col] != color && image[row+1][col] == originalColor)
            dfs(row+1, col, image, color, originalColor);
    }
}