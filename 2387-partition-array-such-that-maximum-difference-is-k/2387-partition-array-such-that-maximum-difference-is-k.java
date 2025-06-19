class Solution {
    public int partitionArray(int[] nums, int k) {
        int n = nums.length;
        //sort the array
        Arrays.sort(nums);
        int minVal = nums[0];
        int count = 1; //initial number of subsequences

        for(int i=0; i<n; i++) {
            if(nums[i] - minVal > k) {
                count++;
                minVal = nums[i];
            }
        }

        return count;
    }
}