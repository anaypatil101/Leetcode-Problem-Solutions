class Solution {
    public boolean searchMatrix(int[][] mat, int target) {
        int n = mat.length;
        int m = mat[0].length;

        for(int i=0; i<n; i++) {
            if(mat[i][0] <= target && mat[i][m-1] >= target) {
                if(binarySearch(mat[i],target))
                    return true;
            }
        }
        return false;
    }
    
    private boolean binarySearch(int[] arr, int target) {
        int n = arr.length;
        int low = 0, high = n - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if(arr[mid] == target)
                return true;
            else if(arr[mid] > target) 
                high = mid - 1;
            else 
                low = mid + 1;
        }
        return false;
    }
}
