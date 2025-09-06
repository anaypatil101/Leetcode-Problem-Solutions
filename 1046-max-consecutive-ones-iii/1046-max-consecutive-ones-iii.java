class Solution {
    public int longestOnes(int[] nums, int k) {
         int n = nums.length;
        int zeroes = 0;
        int maxLen = 0, r = 0, l = 0;

        while(r < n) {
            if(nums[r] == 0) zeroes++;

            if(zeroes > k) {
                while(zeroes > k) {
                    if(nums[l] == 0) zeroes--;
                    l++;
                }
            }
            else {
                int len = r - l + 1;
                maxLen = Math.max(maxLen, len);
            }
            r++;
        }
        return maxLen;
    }
}