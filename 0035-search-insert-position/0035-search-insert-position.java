class Solution {
    public int searchInsert(int[] nums, int target) {
      int n = nums.length;
      int result = n;

      int low = 0, high = n -1;
      while(low <= high) {
        int mid = (low + high) / 2;

        if(nums[mid] >= target) {
            result = mid;
            high = mid - 1;
        }
        else {
            low = mid + 1;
        }
    }
    return result;
  }
}
