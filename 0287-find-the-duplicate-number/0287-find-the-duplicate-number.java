class Solution {
    public int findDuplicate(int[] nums) {
        int prev = -1;
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            if(nums[i] == prev) {
                return nums[i];
            }

            prev = nums[i];
        }

        return -1;
    }
}