class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
                int n = nums.length;
        int currSum = 0, count = 0;
        for(int i=0; i<n; i++) {
            currSum = 0;
            for(int j=i; j<n; j++) {
                currSum += nums[j];

                if(currSum < goal) 
                    continue;
                else if(currSum == goal)
                    count++;
                else 
                    break;
            }
        }
        return count;
    }
}