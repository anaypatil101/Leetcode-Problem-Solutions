class Solution {
    public int search(int[] nums, int key) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while(low <= high) {
            int mid = (low+high)/2;

            if(key < nums[mid]) {
                high = mid - 1;
            }
            else if(key > nums[mid]) {
                low = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }
}