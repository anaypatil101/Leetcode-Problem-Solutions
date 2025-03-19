class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;

        int j = 1, i = 0;
        while(j < n) {
            if(nums[j] != nums[i]) {
                nums[i + 1] = nums[j];
                i++;
                j++;
            }
            else {
                j++;
            }
        }

        return i+1;
    }
}