class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }

        int n = nums.length;
        int count = 0;
        int curr = -1;
        
        for(int num : nums) {
            
            if(curr != num) {
                if(count == 1) {
                    return curr;
                }
                else {
                    curr = num;
                    count = 1;
                }
            }
            else {
                count++;
            }
        }   


        return curr;
    } 
}