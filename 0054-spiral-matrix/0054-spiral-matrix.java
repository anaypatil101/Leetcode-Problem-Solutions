class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<>();
        int n = matrix.length;
        int m = matrix[0].length;
        int top, down, left, right;
        top = 0; left = 0;
        down = n - 1; right = m - 1;    

        while(top <= down && left <= right) {
            for(int i = left; i<=right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            for(int i=top; i<=down; i++) {
                ans.add(matrix[i][right]);
            }
            right--;

            //traverse from right to left
            if (top <= down) {
                for (int i = right; i >= left; --i) {
                    ans.add(matrix[down][i]);
                }
             down--;
            }
            
            // Traverse from down to top
            if (left <= right) {
                for (int i = down; i >= top; --i) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        
        return ans;
    }
}