class Solution {
    public int[] sortArrayByParity(int[] nums) {

        if(nums.length == 1) return nums;

        int n = nums.length;
        int i = 0, j = n - 1;
        //move i to the nearest odd element and j to nearest even
        
        while(i < j) {
            if(nums[i] % 2 != 0 && nums[j] % 2 == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++; j--;
            }
            else if(nums[i] % 2 == 0)
                i++;
            else 
                j--;
        }
        
        return nums;
    }
}